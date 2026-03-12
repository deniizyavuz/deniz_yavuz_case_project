from locust import HttpUser, task, between
import random
import csv
import os


def load_keywords():
    keywords = []
    base_dir = os.path.dirname(__file__)
    csv_path = os.path.join(base_dir, "../data/keywords.csv")

    with open(csv_path, encoding="utf-8") as f:
        reader = csv.DictReader(f)
        for row in reader:
            keywords.append(row["klavye"])

    return keywords


keywords = load_keywords()


class SearchUser(HttpUser):

    wait_time = between(1, 3)

    headers = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 Chrome/122.0.0.0 Safari/537.36",
        "Accept-Language": "tr-TR,tr;q=0.9,en-US;q=0.8,en;q=0.7",
        "Connection": "keep-alive",
        "Referer": "https://www.n11.com/",
    }

    def on_start(self):
        """
        User siteye ilk giriş yapar
        """
        self.client.get("/", headers=self.headers, name="Landing Page")

    @task(3)
    def search(self):
        """
        Kullanıcı ürün araması yapar
        """
        keyword = random.choice(keywords)

        self.client.get(
            "/arama",
            params={"q": keyword},
            headers=self.headers,
            name="Search Page",
        )

    @task(2)
    def autocomplete(self):
        """
        Kullanıcı search bar'da autocomplete kullanır
        """
        keyword = random.choice(keywords)

        self.client.get(
            "/rest/v1/searchAutoCompleteService",
            params={"q": keyword, "state": "f"},
            headers=self.headers,
            name="Autocomplete API",
        )