package com.july.backend.util;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.july.backend.models.Books;

public class Crawler {
	private String url;

	public Crawler() {
	}

	public Crawler(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void runCrawler() {

		Document doc, docBook;
		try {
			doc = Jsoup.connect(url).get();
			Elements links = doc.getElementsByAttribute("data-title");
			for (Element element : links) {
				Books book = new Books();
				Session session = HibernateUtil.getSessionFatory().openSession();

				book.setUrlBook(element.select("a").attr("href"));

				docBook = Jsoup.connect(book.getUrlBook()).get();

				book.setNamebook(docBook.getElementById("product-name").text());
				book.setPrice(Integer.valueOf(docBook.getElementById("p-specialprice").attr("data-value")));
				book.setImage(docBook.getElementById("product-magiczoom").attr("src"));

				Element table = docBook.getElementById("chi-tiet");
				Elements rows = table.select("tr");
				for (Element row : rows) {
					Elements cols = row.select("td");
					String rel = cols.get(0).attr("rel");
					switch (rel) {
					case "manufacturer_book_vn":
						book.setPublish(cols.get(1).text());
						break;
					case "author":
						book.setAuthor(cols.get(1).text());
						break;
					default:
						break;
					}
				}
				System.out.println(book.toString());
				Transaction transaction = session.beginTransaction();
				session.save(book);
				transaction.commit();
				session.close();
			}
			System.out.println("Done Crawler");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Crawler crawler = new Crawler();
		String baseurl = "https://tiki.vn/nha-sach-tiki/c8322?page=";
		String url;
		for (int i = 1; i <= 1; i++) {
			url = baseurl + i;
			crawler.setUrl(url);
			crawler.runCrawler();
		}
	}

}
