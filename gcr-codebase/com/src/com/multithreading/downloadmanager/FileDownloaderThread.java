package com.multithreading.downloadmanager;

import java.util.Random;

class FileDownloaderThread extends Thread {

	private String fileName;
	private Random random = new Random();

	public FileDownloaderThread(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void run() {
		downloadFile();
	}

	private void downloadFile() {
		for (int progress = 0; progress <= 100; progress += 10) {
			try {
				Thread.sleep(random.nextInt(500) + 200); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(
					"[" + Thread.currentThread().getName() + "] Downloading " + fileName + ": " + progress + "%");
		}
	}
}