package linkedlist;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		Manager manager = new Manager();
		manager.kayit();
		//Long say� giri�lerinde say�n�n sonuna L koyulur
		manager.insert(5688987855L, "dsfdasfasd,sadfsadfs");
		manager.nodeSearch(5688987855L);
		manager.returnKayit(7);
		manager.delete(5688987855L);
		manager.ekranaYazdir();
		manager.size();

	}
}
