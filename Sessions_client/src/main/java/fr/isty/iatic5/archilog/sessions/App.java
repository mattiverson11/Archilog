package fr.isty.iatic5.archilog.sessions;

import java.awt.EventQueue;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.isty.iatic5.archilog.ihm.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@SpringBootApplication
@EnableSwagger2

public class App {

public static void main(String[] args) {


EventQueue.invokeLater(new Runnable() {
	public void run() {
		try {
			
			MainWindow window = new MainWindow(null);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
});

SpringApplication.run(App.class, args);
}

}