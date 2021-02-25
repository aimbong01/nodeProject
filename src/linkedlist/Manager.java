package linkedlist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Manager {

	Node head;
	public int size;
	String adsoyad;

	public Manager() {

		head = null;
		size = 0;
	}
	
	
	
	public void kayit() throws IOException {
		File file = new File(System.getProperty("user.dir") + "/src/kayit_dosyasi.txt");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String currentLine = bufferedReader.readLine();
		ArrayList<Long> tc = new ArrayList<Long>();
		ArrayList<String> adsoyad = new ArrayList<String>();

		int i = 0;
		int counter = 0;
		while (counter < 5000) {
			String[] metinBol = currentLine.split(",");
			tc.add(Long.parseLong(metinBol[0]));
			adsoyad.add(metinBol[1] + "," + metinBol[2]);
			currentLine = bufferedReader.readLine();
			insert(tc.get(i), adsoyad.get(i));
			i++;
			counter++;
		}
	}
	
	

	public void size() {
		System.out.println(size);
	}

	public void insert(long tc, String adsoyad) {
		Node nptr, ptr, tmp = null;

		nptr = new Node(tc, tc + "," + adsoyad, null);
		boolean ins = false;
		if (head == null) {
			head = nptr;
		} else if (tc <= head.getTc()) {
			nptr.setLink(head);
			head = nptr;
		} else {
			tmp = head;
			ptr = head.getLink();
			while (ptr != null) {
				if (tc >= tmp.getTc() && tc <= ptr.getTc()) {
					tmp.setLink(nptr);
					nptr.setLink(ptr);
					ins = true;
					break;
				} else {
					tmp = ptr;
					ptr = ptr.getLink();
				}

			}
			if (ins == false) {
				tmp.setLink(nptr);
			}
		}
		size++;
	}

	public void delete(long tc) {

		Node ptr = head;
		int i;
		int kontrol = 0;
		for (i = 1; i <= size; i++) {
			if (ptr.getTc() == tc) {
				Node tmp = ptr.getLink();
				tmp = tmp.getLink();
				ptr.setLink(tmp);
				kontrol++;
				break;
			}
			ptr = ptr.getLink();

		}
		if (kontrol == 1) {
			System.out.println("Silinen tc'nin sýrasý: " + i);
		} else {
			System.out.println("Veri bulunamadý");
		}
		size--;
	}

	public void ekranaYazdir() {
		System.out.println("TÜM VERÝLER");
		if (size == 0) {
			System.out.println("liste boþ");
			return;
		}
		if (head.getLink() == null) {
			System.out.println(head.getData() + "," + head.getData());
			return;
		}
		Node ptr = head;
		int i = 1;
		System.out.println(i + ".veri: " + head.getData());
		ptr = head.getLink();
		while (ptr.getLink() != null) {
			System.out.println(i + 1 + ".veri: " + ptr.getData());
			ptr = ptr.getLink();
			i++;
		}
		System.out.println((i + 1) + ".veri: " + ptr.getData());
	}

	public void nodeSearch(long searchTc) {
		Node aranan = head;
		int i = 1;
		boolean flag = false;
		if (head == null) {
			System.out.println("liste boþ");
		} else {
			while (aranan != null) {
				if (aranan.getTc() == searchTc) {
					flag = true;
					break;
				}
				i++;
				aranan = aranan.next;
			}
		}
		if (flag) {
			System.out.println("Verinin bulunduðu node sýrasý:" + i + "\nKalan node sayýsý: " + (size - i));
		} else {
			System.out.println("Veri bulunamadý");
		}
	}

	public void returnKayit(int pos) {
		Node ptr = head;
		if (pos > size) {
			System.out.println("Veri bulunamadý");
		} else {
			for (int i = 1; i <= pos; i++) {
				if (i == pos) {
					System.out.println(i + ". node sýrasýnda bulunan veri: " + ptr.getData());
					break;
				}

				ptr = ptr.getLink();
			}

		}

	}

}