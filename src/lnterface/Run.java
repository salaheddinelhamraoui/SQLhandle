package lnterface;


import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import com.sun.java.accessibility.util.TopLevelWindowListener;

import DbManagment.DbConnection;
import models.Create;
import models.Database;
import models.Drop_sql;
import models.Export;
import models.Import;
import models.R_TO_JT;
import models.Sticture;
import models.Table;
import models.resultTable;
import models.Upload;
public class Run {
	private static Connection cnx = null;
	private static Vector<Database> databases;	
	private static int x=0;
	private static DbConnection con = new DbConnection();
	int i =0;
	public Run() {
		JFrame creation_of_db=new JFrame();
		Login.getValideButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {				 
				String s1, s2, s3;
				s1 = Login.getF_UserName().getText();
				s2 = String.valueOf(Login.getF_Password().getPassword());
				s3 = Login.getL_port().getText();
				Login.getJerror_message().setText("");
				if (s1.equals("") || s3.equals("")) {
					if (s1.equals("")) {
						Login.getJerror_message().setText("Le nom de l'utilisateur est vide !!");
					}
					if (s3.equals("")) {
						Login.getJerror_message().setText("Le port est vide !!");
					}

				} else {

					con.setUsername(s1);
					con.setPassword(s2);
					con.setPort(s3);

					cnx = con.getConnection();

					if (con.getError_statut() == 1) {
						Login.getJerror_message().setText(con.getError_message());
					} else {
						databases = Upload.upload(cnx);
						Principal.getPrincipal(databases).setVisible(true);
						Login.getLogin().setVisible(false);
						if(cnx!=null)
							Upload.historique(cnx);
					}

				}

			}
		});

		Jtree.getItem2().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				javax.swing.tree.TreePath[] path=Jtree.getTree().getSelectionPaths();
				DefaultMutableTreeNode test=(DefaultMutableTreeNode) path[0].getLastPathComponent();
				if(test.isRoot())
					JOptionPane.showMessageDialog(new JFrame(),"sélectionner un tableau !"
						    ,
						    "imspossible",
						    JOptionPane.WARNING_MESSAGE);
				else if(test.isLeaf()) {
				String dbname = path[0].getPathComponent(1).toString();
				String Tname = path[0].getPathComponent(2).toString();
				St_Panel p = new St_Panel();
				String s2;
				s2=Tname+" stricture";
				Pnael_down_right_top.getTab().add(s2,p.get_creation_panel(databases,dbname, Tname));
				}else
					JOptionPane.showMessageDialog(new JFrame(),"sélectionner un tableau !"
						    ,
						    "imspossible",
						    JOptionPane.WARNING_MESSAGE);
					
					
				
			}
				
			
		});
		Menu_top.getI6().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				resultTable tmp0 = Upload.gethistorique("sqlHandle","historique", cnx);
				Result_Panel tmp= new Result_Panel();
				Pnael_down_right_top.getTab().add("historique",tmp.get_resulte_panel(tmp0));
				
				
			}
		});
		Jtree.getItem1().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				javax.swing.tree.TreePath[] path=Jtree.getTree().getSelectionPaths();
				DefaultMutableTreeNode test=(DefaultMutableTreeNode) path[0].getLastPathComponent();
				if(test.isRoot())
					JOptionPane.showMessageDialog(new JFrame(),"sélectionner un tableau !"
						    ,
						    "imspossible",
						    JOptionPane.WARNING_MESSAGE);
				else if(test.isLeaf()) {
					resultTable tmp0 = Upload.getSELECT(databases,path[0].getPathComponent(1).toString(),test.toString(), cnx);
					Result_Panel tmp= new Result_Panel();
					Panel_down_right_Bottom.getTab().add("tableau : "+test.toString(),tmp.get_resulte_panel(tmp0));
					
				}
				else
					JOptionPane.showMessageDialog(new JFrame(),"sélectionner un tableau !"
						    ,
						    "imspossible",
						    JOptionPane.WARNING_MESSAGE);
					
					
				
			}
		});
		Jtree.getItem3().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				javax.swing.tree.TreePath[] path=Jtree.getTree().getSelectionPaths();
				DefaultMutableTreeNode test=(DefaultMutableTreeNode) path[0].getLastPathComponent();
				if(test.isRoot())
					JOptionPane.showMessageDialog(new JFrame(),"sélectionner un tableau !"
						    ,
						    "imspossible",
						    JOptionPane.WARNING_MESSAGE);
				else if(test.isLeaf()) {
					remplir_panel tmp= new remplir_panel();
					 int dbindex = Sticture.dbindex(databases,path[0].getPathComponent(1).toString());
					int tindex = Sticture.Tindex(databases,path[0].getPathComponent(1).toString(),test.toString());
					Table table = databases.get(dbindex).getTables().get(tindex);
					
					
					Pnael_down_right_top.getTab().add("insérer dans "+test.toString(),tmp.getRemplir_panel(table,path[0].getPathComponent(1).toString()));
					
				}
				else
					JOptionPane.showMessageDialog(new JFrame(),"sélectionner un tableau !"
						    ,
						    "imspossible",
						    JOptionPane.WARNING_MESSAGE);
					
					
				
			}
		});

		ToolBar.getBtnNew().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
	
			}
		});

		
		Menu_top.getI1().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(x==0)
				Pnael_down_right_top.getTab().add("nouveau tableau",NewTable.get_creation_panel(true));
				else 
					Pnael_down_right_top.getTab().add("nouveau tableau",NewTable.get_creation_panel(false ));			
				Menu_top.getI1().setEnabled(false);
				x++;
			}
		});
		
		
		NewTable.getClear().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
						creationOfTab_down.remove();
			        	CreationOfTable_top.getDb_name().setText("");
			        	CreationOfTable_top.getTables_number().setText("");
			}
		});
		
		
		NewTable.getClose().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ToolBar.getBtnNew().setEnabled(true);
				Menu_top.getI1().setEnabled(true);
				Pnael_down_right_top.getTab().remove(Pnael_down_right_top.getTab().getSelectedIndex() );
							
			}
		});
		CreationOfTable_top.getBtn_exe().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(CreationOfTable_top.getDb_name().getText().isEmpty() || CreationOfTable_top.getTables_number().getText().isEmpty()) {
					String msg="";
					if(CreationOfTable_top.getDb_name().getText().isEmpty())
						msg="le nom du tableau est vide ! \n";
					if(CreationOfTable_top.getTables_number().getText().isEmpty())
						msg=msg+"le nombre du colonne est vide !";
					JOptionPane.showMessageDialog(new JFrame(),msg
						    ,
						    "impossible",
						    JOptionPane.WARNING_MESSAGE);	
				}
				else 
				{
					creationOfTab_down.getTable().removeAll();
					int i = Integer.parseInt(CreationOfTable_top.getTables_number().getText());
					creationOfTab_down.addRow(i);	
					//System.out.println(i);
				}
			}
		});
	
		NewTable.getExecute().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				javax.swing.tree.TreePath[] path=Jtree.getTree().getSelectionPaths();
				
				if(path==null || CreationOfTable_top.getDb_name().getText().isEmpty() || CreationOfTable_top.getTables_number().getText().isEmpty()) {
					String msg="";
					if(CreationOfTable_top.getDb_name().getText().isEmpty())
						msg="le nom du tableau est vide ! \n";
					if(CreationOfTable_top.getTables_number().getText().isEmpty())
						msg=msg+"le nombre du colonne est vide !\n";
					if(path==null)
						msg=msg+"aucune base de donnee est selectionne !";
					
					JOptionPane.showMessageDialog(new JFrame(),msg
						    ,
						    "imspossible",
						    JOptionPane.WARNING_MESSAGE);
				}
				else {
					int m=Integer.parseInt(CreationOfTable_top.getTables_number().getText());
					StringBuffer sql=creationOfTab_down.toSqlCode( creationOfTab_down.getTable(),CreationOfTable_top.getDb_name().getText(),m);
					if(Create.create_tab(cnx, sql, path[0].getPathComponent(1).toString())==true) {
						if(test_vide(databases,path[0].getPathComponent(1).toString()))
							Jtree.find_remove_default(path[0].getPathComponent(1).toString());
						Jtree.find_add_default(path[0].getPathComponent(1).toString(),CreationOfTable_top.getDb_name().getText());
						ToolBar.getBtnNew().setEnabled(true);
						Menu_top.getI1().setEnabled(true);
						Pnael_down_right_top.getTab().remove(Pnael_down_right_top.getTab().getSelectedIndex());
						add_table_to_vector(path[0].getPathComponent(1).toString(), CreationOfTable_top.getDb_name().getText(),cnx);
						Jtree.reload();
						JOptionPane.showMessageDialog(new JFrame(), "table cree", "Message", JOptionPane.PLAIN_MESSAGE);
						Upload.addToHistorique(cnx, "creation d un table ", con.getUsername(), sql.toString());
					}
					
				} 
				
				
				
			}
		});
		
		Menu_top.getI2().addActionListener(new ActionListener() {
			Database tmp = new Database();
			String error="";
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			      
			    String name=JOptionPane.showInputDialog(creation_of_db,error+"\nEntrer le nom "); 
			    while(name.isEmpty()) {
			    	error="le nom de base de donnee est vide ";
			    	 name=JOptionPane.showInputDialog(creation_of_db,error+"\nEntrer le nom ");
			    	
			    }
			    if(Create.create_db(cnx, name))
			    {
			    tmp.setName(name);
			    tmp.setTables(new Vector<Table>());
			    databases.add(tmp);
			    Jtree.addDb(name);
			    Jtree.reload();
			    Upload.addToHistorique(cnx, "creation d une base de donnee ", con.getUsername(),"create database "+name+";");
			    }
			   

			    					
			}
		});
		Menu_top.getI1_2().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			      
				Pnael_down_right_top.getTab().add("importation",Import_Panel.get_creation_panel(true));
				Menu_top.getI1_2().setEnabled(false);
			}
		});
		
		Import_Panel.getBrowse().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				FileDialog fd = new FileDialog(new JFrame());
				fd.setVisible(true);
				File[] f = fd.getFiles();
				if(f.length > 0){
					
					Import_Panel.getFile_path().setText(fd.getFiles()[0].getAbsolutePath());
				//	Import_Panel.getErr_message_l().setText("test");
				
			
						

				//	Import_Panel.getBrowse().setText(i.getMessage());
				}
				
			}
		});
		
		Import_Panel.getValide().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Import i = new Import(Import_Panel.getFile_path().getText());
				boolean b1 = i.executer(cnx);
				databases=Upload.uploadNewDb(databases, cnx);
				Jtree.addImport(databases.get(databases.size()-1));
				Jtree.reload();
				if(b1==false) {
					
					JOptionPane.showMessageDialog(null, "Le script est bien executee");
				}else {
					JOptionPane.showMessageDialog(null, "Error at Backuprestore" + i.getMessage());
					
				}
			}
		});
		
        Menu_top.getI2_2().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			 Export_Panel p = new Export_Panel();
				Pnael_down_right_top.getTab().add("exportation",p.get_creation_panel(true)); 
				 Menu_top.getI2_2().setEnabled(false);
		
				
				
			}
		});
        
         Export_Panel.getValide_b().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Export i = new Export(Export_Panel.getTf_save_path().getText(),Export_Panel.getTf_db_name().getText(),Export_Panel.getTf_mysql_path().getText());
				i.Backupdbtosql();
				
				
				
			}
		});
         
         Export_Panel.getSave_path_b().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser f = new JFileChooser();
		        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
		        f.showSaveDialog(null);
		        File F = f.getSelectedFile();
		        String s = F.getPath();
		        Export_Panel.getTf_save_path().setText(s);
			}
		});
         Export_Panel.getMysql_path_b().addActionListener(new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				// TODO Auto-generated method stub
 				JFileChooser f = new JFileChooser();
 		        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
 		        f.showSaveDialog(null);
 		        File F = f.getSelectedFile();
 		        String s = F.getPath();
 		        Export_Panel.getTf_mysql_path().setText(s);
 			}
 		});
         
         Jtree.getItem0().addActionListener(new ActionListener() {

 			@Override
 			public void actionPerformed(ActionEvent e) {
 				// TODO Auto-generated method stub
 				javax.swing.tree.TreePath[] path=Jtree.getTree().getSelectionPaths();
 				if(path==null )
 					JOptionPane.showMessageDialog(new JFrame(),"selectionner l'element a supprimer"
 						    ,
 						    "impossible",
 						    JOptionPane.WARNING_MESSAGE);
 				else {					
 					DefaultMutableTreeNode test=(DefaultMutableTreeNode) path[0].getLastPathComponent();
 					if(test.isLeaf()) {
 						
 						if(showConfirmDialog("?")==0) {
 							
 							Drop_sql.drop_tab(cnx,test.toString(), path[0].getPathComponent(1).toString());
 							databases=remove_tables_from_vector(databases, test.toString());
 							Jtree.deleteSelectedItems();
 							if(test_vide(databases, path[0].getPathComponent(1).toString())) {
 								Jtree.find_add_default(path[0].getPathComponent(1).toString(),"<html><p style=color:gray;>aucun tableau!</p></html>");
 								
 							}
 							
 								
 							
 						}
 							
 					}
 						
 					else if(test.isRoot())
 						JOptionPane.showMessageDialog(new JFrame(),"impossible de supprimer ce node"
 							    ,
 							    "impossible",
 							    JOptionPane.WARNING_MESSAGE);
 					else if(test.toString().equals("<html><p style=color:gray;>aucun tableau!</p></html>")) {
 						JOptionPane.showMessageDialog(new JFrame(),"impossible de supprimer ce node"
 							    ,
 							    "impossible",
 							    JOptionPane.WARNING_MESSAGE);
 					}
 					else 
 					{
 						if(!test_vide(databases, test.toString())) {
 							JOptionPane.showMessageDialog(new JFrame(),"la base de donnee n'est pas vide "
 								    ,
 								    "Message",
 								    JOptionPane.WARNING_MESSAGE);
 						}
 						else
 						{
 							if(showConfirmDialog("?")==0)
 							{
 								Drop_sql.drop_db(cnx,test.toString());Jtree.deleteSelectedItems();
 								databases=remove_db_from_vector(databases,test.toString() );
 								
 							}
 							

 						}
 					}
 				}
 				Jtree.reload();
 			}
 			
		});

		Jtree_menu_top.getBtn_delete().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				javax.swing.tree.TreePath[] path=Jtree.getTree().getSelectionPaths();
				if(path==null )
					JOptionPane.showMessageDialog(new JFrame(),"selectionner l'element a supprimer"
						    ,
						    "impossible",
						    JOptionPane.WARNING_MESSAGE);
				else {					
					DefaultMutableTreeNode test=(DefaultMutableTreeNode) path[0].getLastPathComponent();
					if(test.isLeaf()) {
						
						if(showConfirmDialog("?")==0) {
							
							Drop_sql.drop_tab(cnx,test.toString(), path[0].getPathComponent(1).toString());
							databases=remove_tables_from_vector(databases, test.toString());
							Jtree.deleteSelectedItems();
							if(test_vide(databases, path[0].getPathComponent(1).toString())) {
								Jtree.find_add_default(path[0].getPathComponent(1).toString(),"<html><p style=color:gray;>aucun tableau!</p></html>");
								
							}
							
								
							
						}
							
					}
						
					else if(test.isRoot())
						JOptionPane.showMessageDialog(new JFrame(),"impossible de supprimer ce node"
							    ,
							    "impossible",
							    JOptionPane.WARNING_MESSAGE);
					else if(test.toString().equals("<html><p style=color:gray;>aucun tableau!</p></html>")) {
						JOptionPane.showMessageDialog(new JFrame(),"impossible de supprimer ce node"
							    ,
							    "impossible",
							    JOptionPane.WARNING_MESSAGE);
					}
					else 
					{
						if(!test_vide(databases, test.toString())) {
							JOptionPane.showMessageDialog(new JFrame(),"la base de donnee n'est pas vide "
								    ,
								    "Message",
								    JOptionPane.WARNING_MESSAGE);
						}
						else
						{
							if(showConfirmDialog("?")==0)
							{
								Drop_sql.drop_db(cnx,test.toString());Jtree.deleteSelectedItems();
								databases=remove_db_from_vector(databases,test.toString() );
								
							}
							

						}
					}
				}
				Jtree.reload();
			}
			
		});
		
		Jtree_menu_top.getBtn_refresh().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Jtree.reload();
				
			
			}
		});
		/* 9991 begin -- Editeur de texte action listners */
		Panel_editeur_de_texte p = new Panel_editeur_de_texte();
		ToolBar.getBtnNew().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Pnael_down_right_top.getTab().add("Editeur de texte", p.get_creation_panel(true));
				Menu_top.getI3().setEnabled(false);
				ToolBar.getBtnNew().setEnabled(false);
				
			}
		});
		

		Menu_top.getI3().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Pnael_down_right_top.getTab().add("Editeur de texte", p.get_creation_panel(true));
				Menu_top.getI3().setEnabled(false);
				ToolBar.getBtnNew().setEnabled(false);

			}
		});

		p.getEffacer().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				p.getPane().setText("");

			}
		});
		
		p.getExecute().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s = p.getPane().getSelectedText();
				javax.swing.tree.TreePath[] path = Jtree.getTree().getSelectionPaths();
				if (path == null)
				{
				JOptionPane.showMessageDialog(null, "Aucune base de donnee est selectionne !");
				}
				else if(s== null) 
				{
					JOptionPane.showMessageDialog(null, "Vous devez choisir du texte");
				}else{
					R_TO_JT Proc = new R_TO_JT(s,cnx,path[0].getPathComponent(1).toString());
					Proc.splite_requetes();
					
					Proc.execute_requetes();
					Upload.addToHistorique(cnx,"l execution d une requête dans editeur du texte",Run.get_user(),Proc.getRequete());
					
					
				}
			}
		});

		/*  End --- Editeur de texte action listners */
	
	}

	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login.getLogin().setVisible(true);
					new Run();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}
	
	// methode 1 :  pour savoir si une base de donne est vide ou non !!
	
	
	public boolean test_vide(Vector<Database> liste,String db) {
		
		for(int i=0;i<liste.size();i++) {
			if(liste.get(i).getName().equals(db)) {
				if(liste.get(i).getTables().size()==0) {
					return true;
				}
					
			}
		}
		return false;
	}
	 static int showConfirmDialog(String msg){
		  return JOptionPane.showConfirmDialog(
		       null,
		       msg,
		       "Message",
		       JOptionPane.YES_NO_OPTION);
		 }
		
	 public static Vector<Database>  remove_tables_from_vector(Vector<Database> liste ,String table) {
		 
			for(int i=0;i<liste.size();i++) 
			{
				
				for(int j=0;j<liste.get(i).getTables().size();j++) {
					if(liste.get(i).getTables().get(j).getName().equals(table)) {
						liste.get(i).getTables().remove(j);
					}
						
		
					
				}
			
			}
		 return liste;
	 }
	 public static Vector<Database> remove_db_from_vector(Vector<Database> liste ,String db) {	 
			for(int i=0;i<liste.size();i++) 
			{			
					if(liste.get(i).getName().equals(db)) {
						liste.remove(i);
		
				}
			
			}	
			return liste;
	 }
	 public void add_table_to_vector (String db,String table,Connection cnx) {	 
		 	Table nmp= Upload.upload_one_table(db, table, cnx);
			for(int i=0;i<databases.size();i++) 
			{	 
				
					if(databases.get(i).getName().equals(db)) {
						databases.get(i).getTables().add(nmp);		 
	 }
	 }
	 }
	 public static Vector<Database> getDatabases() {
			return databases;
		}




	static Connection getCnx() {
		return cnx;
	}
	public static  String get_user() {
		return con.getUsername();
	}
	
		

	  





}
	