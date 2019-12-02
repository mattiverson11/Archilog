package fr.isty.iatic5.archilog.sessions;

import java.awt.EventQueue;

import fr.isty.iatic5.archilog.ihm.*;
import fr.isty.iatic5.archilog.impl.*;
public class App {


	
		
public static void main(String[] args) {
	
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				SessionImplementation sess = new SessionImplementation();
				sess.initDatabase();
				MainWindow window = new MainWindow(sess);
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}
		

	
}
