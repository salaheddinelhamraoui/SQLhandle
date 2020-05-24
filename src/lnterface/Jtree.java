package lnterface;


import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreeSelectionModel;


import models.Database;
public class Jtree {
	private static DefaultMutableTreeNode user=new DefaultMutableTreeNode("<html><strong style=color:black;>"+Run.get_user()+"</strong></html>"),db;
	private static JTree tree= new JTree();
	private static JPanel p= new JPanel();
	private  static JMenuItem item0= new JMenuItem("    SUPPRIMER"),item1= new JMenuItem("    AFFICHER LES ENREGISTREMENTS"),item2= new JMenuItem("    AFFICHER STRUCTURE"),item3= new JMenuItem("    INSÉRER");
	
	

	public static JScrollPane getTree(Vector<Database> databases ) {
		
		for(int i=0;i<databases.size();i++) 
		{
			if(!databases.get(i).getName().equalsIgnoreCase("sqlhandle")) {
			db = new DefaultMutableTreeNode(databases.get(i).getName());
			if(databases.get(i).getTables().size()==0) {
				db.add(new DefaultMutableTreeNode("<html><p style=color:gray;>aucun tableau!</p></html>"));
			}
			else 
			for(int j=0;j<databases.get(i).getTables().size();j++) {
				db.add(new DefaultMutableTreeNode(databases.get(i).getTables().get(j).getName()));
				
			}
			user.add(db);
			}
		}		
		tree = new JTree(user);
		final Font currentFont = tree.getFont();
		final Font bigFont = new Font(currentFont.getName(), currentFont.getStyle(), currentFont.getSize() + 3);
		tree.setFont(bigFont);
		new JScrollPane(tree);
		tree.setRootVisible(true);
		DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
		renderer.setOpenIcon(new ImageIcon("icons/database.png"));  
		renderer.setClosedIcon(new ImageIcon("icons/database.png"));  
		renderer.setLeafIcon(new ImageIcon("icons/table.png"));
		tree.setCellRenderer(renderer);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		p.add(tree);
		p.setBackground(Color.white);
		JScrollPane s= new  JScrollPane(p);
		
		//_----------------------
	    JPopupMenu popupMenu = new JPopupMenu();
	      popupMenu.add(item0);
	      popupMenu.add(new JSeparator());
	      popupMenu.add(item1);
	      popupMenu.addSeparator();
	      popupMenu.add(item2);
	      popupMenu.add(new JSeparator());
	      popupMenu.add(item3);
	      tree.setComponentPopupMenu(popupMenu);

	      initPopupListener(tree, popupMenu);
	      //-----------------------

       return s;
	}

	static JMenuItem getItem3() {
		return item3;
	}

	static JTree getTree() {
		return tree;
	}

	static void setTree(JTree tree) {
		Jtree.tree = tree;
	}	
	static JMenuItem getItem2() {
		return item2;
	}


	public static void find_add_default( String s,String dd) {
		DefaultMutableTreeNode root=Jtree.getUser();
	    Enumeration<TreeNode> e = root.depthFirstEnumeration();
	    while (e.hasMoreElements()) {
	        DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.nextElement();
	        if (node.toString().equalsIgnoreCase(s)) {
	           node.add(new DefaultMutableTreeNode(dd));
	        }
	    }
	    return ;
	}
	public static void find_remove_default( String s) {
		DefaultMutableTreeNode root=Jtree.getUser();
	    Enumeration<TreeNode> e = root.depthFirstEnumeration();
	    while (e.hasMoreElements()) {
	        DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.nextElement();
	        if (node.toString().equalsIgnoreCase(s)) {
	           node.remove(0);
	        }
	    }
	    return ;
	}


	static DefaultMutableTreeNode getUser() {
		return user;
	}

	static void setUser(DefaultMutableTreeNode user) {
		Jtree.user = user;
	}
	public static void addDb(String name) {
		db = new DefaultMutableTreeNode(name);
		db.add(new DefaultMutableTreeNode("<html><p style=color:gray;>aucun tableau!</p></html>"));
		user.add(db);
		
	    }

	public static void addImport(Database newdb) {
		db = new DefaultMutableTreeNode(newdb.getName());
		if(newdb.getTables().size()==0)
			db.add(new DefaultMutableTreeNode("<html><p style=color:gray;>aucun tableau!</p></html>"));
		else
		for(int i=0;i<newdb.getTables().size();i++) {
			
			db.add(new DefaultMutableTreeNode(newdb.getTables().get(i).getName()));
			
		}		
		user.add(db);	
	    }

	
	public static void reload() {
		DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
		DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
		 
		model.reload(root);
	}
	
	
	 public static  void deleteSelectedItems() {
		    DefaultMutableTreeNode node;
		    DefaultTreeModel model = (DefaultTreeModel) (tree.getModel());
		    javax.swing.tree.TreePath[] paths = tree.getSelectionPaths();
		    for (int i = 0; i < paths.length; i++) {
		      node = (DefaultMutableTreeNode) (paths[i].getLastPathComponent());
		      model.removeNodeFromParent(node);
		    }
		  }
	 private static void initPopupListener(JTree tree, JPopupMenu popupMenu) {
	      popupMenu.addPopupMenuListener(new PopupMenuListener() {
	          @Override
	          public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
	              //get selected node's rectangle
	              Rectangle rect = tree.getPathBounds(tree.getSelectionPath());
	              Arrays.stream(popupMenu.getComponents()).forEach(c -> c.setEnabled(rect != null));
	              if (rect == null) {
	                  return;
	              }

	              Point p = new Point(rect.x + rect.width / 2, rect.y + rect.height);
	              SwingUtilities.convertPointToScreen(p, tree);
	              popupMenu.setLocation(p.x, p.y);
	          }

	          @Override
	          public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
	        	  

	          }

	          @Override
	          public void popupMenuCanceled(PopupMenuEvent e) {

	          }
	      });
}

	static JMenuItem getItem0() {
		return item0;
	}

	static JMenuItem getItem1() {
		return item1;
	}

	static void setItem0(JMenuItem item0) {
		Jtree.item0 = item0;
	}

	static void setItem1(JMenuItem item1) {
		Jtree.item1 = item1;
	}
	 
	
	
}
