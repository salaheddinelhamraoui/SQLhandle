package lnterface;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu_top {
	 private static JMenu menu=new JMenu(" Menu"),menu_1= new JMenu("Fichier") , submenu=new JMenu("Sub Menu"); 
	 private static JMenuItem i1=new JMenuItem("   Nouveau tableau                                                     "), i2=new JMenuItem("   Nouvelle base de donnees                ")  
			 ,i3=new JMenuItem("   Editeur de texte"), i4, i5,i1_2= new JMenuItem("Import")
			 ,i2_2= new JMenuItem("Export"),i6=new JMenuItem("   Afficher l'historique");  
	 
     public static JMenuBar MenuExample(){  
    
     JMenuBar mb=new JMenuBar();  
       
     i4=new JMenuItem("   Item 4 .....");  
     i5=new JMenuItem("   Item 5 .....");  
     menu.add(i1); menu.add(i2); menu.add(i3);  menu.add(i6);
     submenu.add(i4); submenu.add(i5);  
     
     menu.add(submenu);
     
     menu_1.add(i1_2);menu_1.add(i2_2);
     mb.add(menu);  
     mb.add(menu_1);

     return  mb;
}
	static JMenuItem getI1_2() {
		return i1_2;
	}
	static JMenuItem getI2_2() {
		return i2_2;
	}
	static JMenu getMenu() {
		return menu;
	}
	static JMenu getSubmenu() {
		return submenu;
	}
	static JMenuItem getI1() {
		return i1;
	}
	static JMenuItem getI2() {
		return i2;
	}
	static JMenuItem getI3() {
		return i3;
	}
	static JMenuItem getI4() {
		return i4;
	}
	static JMenuItem getI5() {
		return i5;
	}
	static void setMenu(JMenu menu) {
		Menu_top.menu = menu;
	}
	static void setSubmenu(JMenu submenu) {
		Menu_top.submenu = submenu;
	}
	static void setI1(JMenuItem i1) {
		Menu_top.i1 = i1;
	}
	static void setI2(JMenuItem i2) {
		Menu_top.i2 = i2;
	}
	static void setI3(JMenuItem i3) {
		Menu_top.i3 = i3;
	}
	static void setI4(JMenuItem i4) {
		Menu_top.i4 = i4;
	}
	static void setI5(JMenuItem i5) {
		Menu_top.i5 = i5;
	}
	static JMenuItem getI6() {
		return i6;
	}
	
     
}
