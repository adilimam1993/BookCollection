/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerd;

import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaClassyLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaLookAndFeel;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.lang.System.exit;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.SingleSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author Adil Imam
 */
public class BookCollectionSystem extends javax.swing.JFrame {

    DefaultTableModel BookDefaultTable;
    DefaultTableModel StudentModelTable;
    DefaultTableModel StudentAccountModelTable;
    DefaultTableModel AvailableBooksModelTable;  
    DefaultListModel ListModel;
    DefaultTableModel CheckedOutBooksModelTable;
    //DefaultTableModel StudentAccountModel;
    SingleSelectionModel tabpane;
    String selected=null;
//List<StudentDatabase> students=new ArrayList();
    StudentDatabase student;
        Connection con=null;
        ResultSet rs=null;
        ResultSet rs1=null;
        Statement statement=null;
        Statement statement1=null;
        PreparedStatement prepare=null;
        CallableStatement call=null;
        
        Boolean flag; 
         
             List<dateFile> datearray=new ArrayList(); 
             List<StudentAccount> studentaccount=new ArrayList();
             /**
     * Creates new form NewJFrame
     */
             
    /**
     * Creates new form NewJFrame
     * @param r
     */
    public BookCollectionSystem(ResultSet r) {
      super("Library Management System");
        initComponents();
       try{
           //r.next();
           //String name=r.getString("name");
          // String id=r.getString("id");
    
                     
       }
       catch(Exception e){e.printStackTrace();}
;        
        
        connect(); 
       BookDefaultTable=(DefaultTableModel)booktable.getModel();
       StudentModelTable=(DefaultTableModel)studenttabel.getModel();
       
           tabpane = verticaltabbedpanel.getModel();
     //  studenttabel.setVisible(false);
   //  StudentAccountModelTable=(DefaultTableModel)StudentAccount.getModel();
     AvailableBooksModelTable=(DefaultTableModel)availablebooks.getModel();
     
     //StudentAccountModelTable=(DefaultTableModel)StudentAccount.getModel();
     CheckedOutBooksModelTable=(DefaultTableModel)checkoutbooks.getModel();
     
     ListModel=new DefaultListModel();
     //Studentlist=new JList(ListModel);
     
   // Studentlist.setModel(ListModel);
    
     System.out.println(OptionPanel.getTabCount());
             //OptionPanel.setEnabledAt(0,false);
          //  OptionPanel.setEnabledAt(2,false);
           // OptionPanel.setEnabledAt(3,false);
        //    OptionPanel.setEnabledAt(4,false);
          //  OptionPanel.setEnabledAt(5,false);
            //OptionPanel.setEnabledAt(,false);
            
         JMenuItem show=new JMenuItem("show");
   //  BookDefaultTable=(DefaultTableModel)tableform.getModel();
    // StudentModelTable=(DefaultTableModel) student_table.getModel();
         filemenu.add(show);
         
         JPopupMenu popup;
         popup=new JPopupMenu();
         
         
         JMenuItem remove=new JMenuItem("Delete Student");
         popup.add(remove);
         
          JMenuItem selectstudent=new JMenuItem("Select Student For Book CheckOut");
          popup.add(selectstudent);
          
         JMenuItem deletebook=new JMenuItem("Delete book");
        popup.add(deletebook);
        
          checkoutbooks.addMouseListener(new MouseAdapter()
          {
          public void mousePressed(MouseEvent me) {
                       
                      int row=checkoutbooks.rowAtPoint(me.getPoint());
                  // System.out.println(row);
                   checkoutbooks.getSelectionModel().setSelectionInterval(row, row);
                  if(me.getButton()==MouseEvent.BUTTON3)
            {
         
              popup.show(checkoutbooks,me.getX(),me.getY());
                // System.out.println(row);
        
            }//To change body of generated methods, choose Tools | Templates.
       
          
          }
          
          
          
          });
          
          booktable.addMouseListener(new MouseAdapter() {
          @Override
          public void mousePressed(MouseEvent me) {
                       
                      int row=booktable.rowAtPoint(me.getPoint());
                  // System.out.println(row);
                   booktable.getSelectionModel().setSelectionInterval(row, row);
                  if(me.getButton()==MouseEvent.BUTTON3)
            {
         
              popup.show(booktable,me.getX(),me.getY());
                // System.out.println(row);
        
            }//To change body of generated methods, choose Tools | Templates.
       
          
          }
          
          
          
          });        
                  
                  
                  
                  
          
    studenttabel.addMouseListener(new MouseAdapter()
    {
        @Override
        public void mousePressed(MouseEvent me) {
        
                  int row=studenttabel.rowAtPoint(me.getPoint());
                  // System.out.println(row);
                   studenttabel.getSelectionModel().setSelectionInterval(row, row);
                  if(me.getButton()==MouseEvent.BUTTON3)
            {
         
              popup.show(studenttabel,me.getX(),me.getY());
                // System.out.println(row);
        
            }//To change body of generated methods, choose Tools | Templates.
        }
      
    });
    
selectstudent.addActionListener(new ActionListener()
{
          @Override
          public void actionPerformed(ActionEvent ae) {
           
             int row=studenttabel.getSelectedRow();
                 //checkout_student.setText("Book reservation for "+StudentModelTable.getValueAt(row,0).toString());
                 ListModel.addElement(StudentModelTable.getValueAt(row,1).toString());
              
             //    Studentlist=new JList(ListModel);
              /*  
                 Studentlist.addListSelectionListener(new ListSelectionListener()
                 {
              //   @Override
                 public void valueChanged(ListSelectionEvent event) {
                     
                      if (!event.getValueIsAdjusting()){
                            Studentlist = (JList)event.getSource();
                                                          
                               
                               System.out.println(Studentlist.getSelectedValue());                             
        }
                 }
                 
                 
                 });*/
          }




});
    remove.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ae) {
        int row=studenttabel.getSelectedRow();
          
             JOptionPane.showInputDialog(BookCollectionSystem.this,"Confirm Delete","Are you sure? ",JOptionPane.QUESTION_MESSAGE);
       int choice=(JOptionPane.showConfirmDialog(BookCollectionSystem.this,"Are you sure?","Confirm Delete",JOptionPane.OK_CANCEL_OPTION));
           
           
        
       if(choice==0)      
            {  connect();
        
        try
        {
                  
           prepare=con.prepareStatement("delete from people.student where id=?");
           prepare.setString(1,StudentModelTable.getValueAt(row,1).toString());
           prepare.executeUpdate();
                  
                 
           JOptionPane.showMessageDialog(BookCollectionSystem.this,"Deletion successful");
        
        }
        catch(SQLException se){se.printStackTrace();}
        
         StudentModelTable.removeRow(row);
         
        }
       
        }
    
    });
    
    deletebook.addActionListener(new ActionListener() {
          
        public void actionPerformed(ActionEvent ae) {
                
                     int row=booktable.getSelectedRow();
               System.out.println("Row Returned: "+row);
        int choice=(JOptionPane.showConfirmDialog(BookCollectionSystem.this,"Are you sure?","Confirm Delete",JOptionPane.OK_CANCEL_OPTION));
           
           
        
       if(choice==0)      
            {  connect();
        
        try
        {
                  
           prepare=con.prepareStatement("delete from people.books where isbn=?");
           prepare.setString(1,BookDefaultTable.getValueAt(row,0).toString());
           prepare.executeUpdate();
                  
                 
           JOptionPane.showMessageDialog(BookCollectionSystem.this,"Deletion successful");
        
        }
        catch(SQLException se){se.printStackTrace();}
        
         BookDefaultTable.removeRow(row);
         
        }
                    
           
        }
      });
    
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jDialog1 = new javax.swing.JDialog();
        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        OptionPanel = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        bookname = new javax.swing.JTextField();
        titletext = new javax.swing.JLabel();
        booktitle = new javax.swing.JTextField();
        authortext = new javax.swing.JLabel();
        bookauthor = new javax.swing.JTextField();
        genreitem = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        genrelist = new javax.swing.JList<>();
        jLabel17 = new javax.swing.JLabel();
        yeartext = new javax.swing.JLabel();
        bookyear = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        searchtext = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        alpha = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jButton20 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        selectstudentlabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        searchbooks = new javax.swing.JComboBox<>();
        searchbookstext = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        verticaltabbedpanel = new javax.swing.JTabbedPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        studenttabel = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        checkoutbooks = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        availablebooks = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        booktable = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        filemenu = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenuItem1.setText("jMenuItem1");

        jMenu3.setText("jMenu3");

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        jMenuItem2.setText("jMenuItem2");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Library Management System");

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setRollover(true);
        jToolBar1.setAutoscrolls(true);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customerd/Save.gif"))); // NOI18N
        jButton2.setToolTipText("Save");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customerd/refresh.gif"))); // NOI18N
        jButton3.setToolTipText("Update Available Books");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customerd/delete.gif"))); // NOI18N
        jButton7.setToolTipText("delete all");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton7);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customerd/import.gif"))); // NOI18N
        jButton8.setToolTipText("Import Data");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton8);

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customerd/export.gif"))); // NOI18N
        jButton13.setToolTipText("Export Data");
        jButton13.setFocusable(false);
        jButton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton13);

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customerd/144846.gif"))); // NOI18N
        jButton14.setToolTipText("About ");
        jButton14.setFocusable(false);
        jButton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton14);

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customerd/clearscreen.gif"))); // NOI18N
        jButton15.setToolTipText("Clear Screen");
        jButton15.setFocusable(false);
        jButton15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton15.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton15);

        OptionPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        OptionPanel.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        OptionPanel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(""), javax.swing.BorderFactory.createEtchedBorder()));

        name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        name.setText("ISBN");

        titletext.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        titletext.setText("Title");

        authortext.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        authortext.setText("Author");

        genreitem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        genreitem.setText("Genre");

        genrelist.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Arts ", "History", "War ", "Science" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(genrelist);

        yeartext.setText("Year");

        bookyear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013" }));

        jButton4.setText("Add to Database");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addComponent(jLabel17)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(genreitem)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(authortext)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(titletext)
                                    .addComponent(name)))
                            .addComponent(yeartext))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(booktitle, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bookname, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bookauthor, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(bookyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(64, 64, 64))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name)
                    .addComponent(bookname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titletext)
                    .addComponent(booktitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(authortext)
                    .addComponent(bookauthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(genreitem)
                        .addGap(94, 94, 94))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yeartext)
                    .addComponent(bookyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jButton4)
                .addGap(33, 33, 33)
                .addComponent(jLabel17)
                .addContainerGap(184, Short.MAX_VALUE))
        );

        OptionPanel.addTab("Add Book Info", jPanel2);

        jPanel5.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search by Name or Id", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP), javax.swing.BorderFactory.createEtchedBorder()));

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customerd/search.gif"))); // NOI18N
        jButton9.setToolTipText("search ");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel15.setText("Name");

        jButton10.setText("Display");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        alpha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" }));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("OR");

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customerd/search.gif"))); // NOI18N
        jButton11.setToolTipText("search\n");

        jLabel28.setText("Id");

        jButton12.setText("Display All Students");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel13.setText("Alphabet");

        jButton20.setText("Display Account");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(alpha, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchtext, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel19))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchtext, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)))
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jButton10)
                    .addComponent(alpha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(34, 34, 34)
                .addComponent(jLabel19)
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton11)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28)))
                .addGap(49, 49, 49)
                .addComponent(jButton12)
                .addGap(30, 30, 30)
                .addComponent(jButton20)
                .addContainerGap(168, Short.MAX_VALUE))
        );

        OptionPanel.addTab("Search Student", jPanel5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 269, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        OptionPanel.addTab("Add Damages", jPanel6);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 269, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        OptionPanel.addTab("Delete Students", jPanel7);

        jPanel8.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search Books", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION), javax.swing.BorderFactory.createEtchedBorder()));

        selectstudentlabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel1.setText("Seach By");

        searchbooks.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ISBN", "Title", "Author", "Year", "Genre", " " }));

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setText("Display All");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchbooks, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchbookstext, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(selectstudentlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(selectstudentlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(searchbooks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchbookstext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addComponent(jButton1)
                .addGap(96, 96, 96)
                .addComponent(jButton5)
                .addContainerGap(254, Short.MAX_VALUE))
        );

        OptionPanel.addTab("Search Book ", jPanel8);

        studenttabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Id", "Number", "Address", "City", "Year of Birth", "Membership"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane6.setViewportView(studenttabel);

        verticaltabbedpanel.addTab("Student Database", jScrollPane6);

        checkoutbooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "ISBN Number", "CheckedOut Date", "Due Date", "Check In"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane7.setViewportView(checkoutbooks);

        verticaltabbedpanel.addTab("Checked Out Books", jScrollPane7);

        availablebooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN Number", "Ttile", "Author", "Genre", "Year", "CheckOut"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(availablebooks);

        verticaltabbedpanel.addTab("Available Books", jScrollPane4);

        booktable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN Number", "Title", "Author", "Genre", "Published Year", "Available"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(booktable);
        if (booktable.getColumnModel().getColumnCount() > 0) {
            booktable.getColumnModel().getColumn(5).setResizable(false);
        }

        verticaltabbedpanel.addTab("Book Database", jScrollPane5);

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Copy Rights Reserved @LibraryManagementSystem2016");

        filemenu.setText("File");
        jMenuBar1.add(filemenu);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OptionPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel33)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(verticaltabbedpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(501, 501, 501)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OptionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(verticaltabbedpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel33)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        // TODO add your handling code here:
        Book b=new Book(bookname.getText(),booktitle.getText(),bookauthor.getText(),genrelist.getSelectedValue(),bookyear.getSelectedItem().toString(),true);
       
        
        Boolean flag=false;
        
        connect();
       try{statement=con.createStatement();
       
        rs=statement.executeQuery("select *from people.books");
            while(rs.next())
            {
              if(rs.getString("isbn").equals(b.getIsbn()))
              {
                flag=true;
               JOptionPane.showMessageDialog(BookCollectionSystem.this,"Duplcation Error","Cannot Add Duplicate Books",JOptionPane.ERROR_MESSAGE);
              }
             
            }
          
       }
       catch(SQLException se){se.printStackTrace();}
     if(flag==false)
     { try{
        prepare=con.prepareStatement("insert into people.books values(?,?,?,?,?,?)");
        
        prepare.setString(1,b.getIsbn());
        prepare.setString(2,b.getTitle());
        prepare.setString(3,b.getAuthor());
        prepare.setString(4,b.getGenre());
        prepare.setString(5,b.getYear());
        prepare.setBoolean(6,b.getAvailable());
        
        prepare.executeUpdate();
        
      BookDefaultTable.insertRow(BookDefaultTable.getRowCount(),new Object[]{b.getIsbn(),b.getTitle(),b.getAuthor(),
          b.getGenre(),b.getYear(),b.getAvailable()
       });
                  tabpane.setSelectedIndex(4);
     }
        
        catch(SQLException ex)
        {
          ex.printStackTrace();;
        }
     }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

     System.out.println("Date array size: "+datearray.size());
        int p=0;
     System.out.println("Unique Student Id's");
        while(p<datearray.size())
        {
         System.out.println(datearray.get(p).getId());
   p++;
        }
        
        connect(); 
        
        for(int i=0;i<StudentModelTable.getRowCount();i++)
         {
               StudentModelTable.fireTableDataChanged();
                Boolean stu_membership=(Boolean)(StudentModelTable.getValueAt(i,6));
                String stu_id=StudentModelTable.getValueAt(i,1).toString();
               
                try
                {
                    prepare=con.prepareStatement("Update people.student set membership=? where id=?");  //this is updates all or nothing
                    prepare.setBoolean(1,stu_membership);
                    prepare.setString(2, stu_id);
                    prepare.executeUpdate();
//                    prepare.close();
                }
                catch(SQLException sql)
                {
                      sql.printStackTrace();
                }
         }
    
      
        try {
            statement=con.createStatement();
              rs =statement.executeQuery("select *from people.student");
              prepare=con.prepareStatement(" insert into people.date (datevaule,id,deadline) values (?,?,?)");
//              rs1=statement.executeQuery("select *from people.date");
              Date d=new Date();
               Calendar c=GregorianCalendar.getInstance();
                    c.setTime(d);
                    c.add(GregorianCalendar.MINUTE,2);
             
             SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             String datenow=sdf.format(d);
             String datethen=sdf.format(c.getTime());
        
             Boolean flag=false;
         while(rs.next())
            {
                
                if(rs.getBoolean("membership")==true)
                {
                 
                    if(datearray.isEmpty())
                    {
                        System.out.println("Executed just one time");
                            datearray.add(new dateFile(datenow,rs.getString("id"),datethen));
                            prepare.setString(1,datenow);                            
                            prepare.setString(2,rs.getString("id"));
                            prepare.setString(3,datethen);
                            prepare.executeUpdate();
                       
                    }
                    else{
                    int i=0;
                    
                    System.out.println("New Node of student");
                        while(i<datearray.size())
                    {  
                        //System.out.println(datearray.size());
                        //System.out.println(datearray.get(i).getId());
                       System.out.println(rs.getString("id")+" "+datearray.get(i).getId());
                       
                        if(rs.getString("id")==(datearray.get(i).getId()))
                        {
                            
                          flag=true;
                          
                           System.out.println("flag is true");
                           break;
                        }
                     i++;
                    }
                     if(flag==false)    
                        {   
                            datearray.add(new dateFile(datenow,rs.getString("id"),datethen));
                    
                            prepare.setString(1,datenow);                            
                            prepare.setString(2,rs.getString("id"));
                            prepare.setString(3,datethen);
                            prepare.executeUpdate();
                       }
                    }
                    }            
               
            }
        
        JOptionPane.showMessageDialog(BookCollectionSystem.this,"Saved Successfully","Success",JOptionPane.INFORMATION_MESSAGE);
        } 
        
        catch (SQLException ex) {
            
                ex.printStackTrace();
        }
       
        
    }//GEN-LAST:event_jButton2ActionPerformed
public void disconnect(){
    try{
    con.close();
    statement.close();
  prepare.close();
}
 catch(SQLException e){e.printStackTrace();}   

}

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       
       connect();
        try {
            statement=con.createStatement();
          rs=statement.executeQuery("select *from people.student where name='"+searchtext.getText()+"'");
  //        rs=statement.executeQuery("select *from people.student where name='raakhi sawant'");
           //StudentModelTable.removeRow();
         //  System.out.println();
             
              if(!rs.next())
              {
                       JOptionPane.showMessageDialog(BookCollectionSystem.this,"Did not match any student in the database","Not Matched",JOptionPane.ERROR_MESSAGE);
                  
              }
              else{
                  StudentModelTable.setRowCount(0);
         rs.previous();  //this is very important
         
              while(rs.next())
          {
             StudentModelTable.insertRow(StudentModelTable.getRowCount(), new Object[]{rs.getString(1),rs.getString(2),
              
             rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getBoolean(7)
      
            //System.out.println(rs.getString("name"));
              
             });
               
          
          }  }
              
        tabpane.setSelectedIndex(1);
        } 
              catch (SQLException ex) {
            
           ex.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try {
             connect();
            
             statement=con.createStatement();
             rs=statement.executeQuery("select *from people.student where name like '"+alpha.getSelectedItem().toString()+"%'");
             
             //now this should work
              if(!rs.next())
              {
                       JOptionPane.showMessageDialog(BookCollectionSystem.this,"Did not match any student in the database","Not Matched",JOptionPane.ERROR_MESSAGE);
                  
              }
              else{
                  StudentModelTable.setRowCount(0);
         rs.previous();  //this is very important
         
              while(rs.next())
          {
             StudentModelTable.insertRow(StudentModelTable.getRowCount(), new Object[]{rs.getString(1),rs.getString(2),
              
             rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getBoolean(7)
      
            //System.out.println(rs.getString("name"));
              
             });
               
          
          }  }
             
             tabpane.setSelectedIndex(1);
        } 
        catch (SQLException ex) {
           
        ex.printStackTrace();
        }
         
         
               


    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed

        try {
             connect();
            
             statement=con.createStatement();
             rs=statement.executeQuery("select *from people.student");
             
             //now this should work
              if(!rs.next())
              {
              JOptionPane.showMessageDialog(BookCollectionSystem.this,"There is no Student in the record","Empty Database",JOptionPane.ERROR_MESSAGE);
                  
              }
              else{
                  StudentModelTable.setRowCount(0);
         rs.previous();  //this is very important
         
              while(rs.next())
          {
             StudentModelTable.insertRow(StudentModelTable.getRowCount(), new Object[]{rs.getString(1),rs.getString(2),
              
             rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getBoolean(7)
      
            //System.out.println(rs.getString("name"));
              
             });
               
          
          }  }
             
         tabpane.setSelectedIndex(0);
              
        } 
        catch (SQLException ex) {
           
        ex.printStackTrace();
        }
         
           
 






    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
                //      System.out.println(StudentModelTable.getRowCount());
          int i=0;
                    int row_count=StudentModelTable.getRowCount();

    
                while(i<StudentModelTable.getRowCount())
                { StudentModelTable.removeRow(i);
                
                  i++;
                }
               
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//this refresh is only for when books are added to books table, and u want to populate it available books table//
        connect();
        
        try {
            statement=con.createStatement();
            rs=statement.executeQuery("select *from people.books");
            prepare=con.prepareStatement("insert into people.availabebooks values(?,?)");
            statement1=con.createStatement();
            rs1=statement1.executeQuery("select *from availabebooks");
            Boolean flag=false;
            
           while(rs.next())
           {
                  if(rs.getBoolean("availability")==true)   //books set
                  {
                                   while(rs1.next())
                                   {
                                     if(rs.getString("isbn").equals(rs1.getString("isbn")))
                                     {
                                         flag=true;
                                         //break;
                                     }                                     
                                   }
                                   
                                   
                               if(flag==false)
                               {
                                         prepare.setString(1,rs.getString("isbn"));
                                         prepare.setBoolean(2,false);
                                         prepare.executeUpdate();                                     
                               
                               }
                       
                               flag=false;       //this is a very important step
                  }
           
           }
           
       //insert into checkout table but make sure that same elements are not added twice    
         //  prepare.setString(2,);
           
           JOptionPane.showMessageDialog(this,"Successfully updated into the database","Successfull",JOptionPane.INFORMATION_MESSAGE);
        
        }
        catch(SQLException se){se.printStackTrace();}
        


        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
     
                StudentAccountModelTable.setRowCount(0);
                GregorianCalendar c=new GregorianCalendar();
                Date d=new Date();
                double doub;    
              SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
               
                
                connect();
                         
        try {
            
            statement=con.createStatement();
            statement1=con.createStatement();
           
            
            rs=statement.executeQuery("select *from people.checkedout_books");
             
                  prepare=con.prepareStatement("update people.studentaccount set Balance=? where StudentId=?");
            
            while(rs.next())
                    {
                       if(d.after(sdf.parse(rs.getString("due_date"))))
                       {
                           rs1=statement1.executeQuery("select Balance from people.studentaccount where StudentId='"+rs.getString("id")+"'");
                           rs1.next();
                         
                          doub=rs1.getDouble("Balance");
                                  
                           prepare.setDouble(1,doub+10.00);
                           prepare.setString(2,rs.getString("id"));
                           prepare.executeUpdate();
                       
                       
                       }
                    }
            
            
            
            
            
            rs=statement.executeQuery("select *from people.studentaccount");
              
            while(rs.next())
             {
     StudentAccountModelTable.insertRow(StudentAccountModelTable.getRowCount(),
             new Object[]{rs.getInt("AccountId"),rs.getString("StudentId"),"$"+rs.getDouble("Balance")});
                                    
             }
             
               tabpane.setSelectedIndex(0);

               
               
               
               
               
               
               
            }
        catch (SQLException ex) {
             ex.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(BookCollectionSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
                       
        /*
         // Recipient's email ID needs to be mentioned.
      String to = "k122261@nu.edu.pk";

      // Sender's email ID needs to be mentioned
      String from = "aimam1@oldwestbury.edu";

      // Assuming you are sending email from localhost
      
      // Get system properties
      Properties properties = new Properties();

      // Setup mail server
      properties.put("mail.smtp.host","smtp.gmail.com");
      properties.put("mail.smtp.socketFactory.port","465");
      properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
      properties.put("mail.smtp.auth","true");
      properties.put("mail.smtp.","465");

     // Get the default Session object.
      Session session = Session.getDefaultInstance(properties,   
              
              new javax.mail.Authenticator() {
                  
                  protected PasswordAuthentication getPasswordAuthentication()
                   {
                     return new PasswordAuthentication("aimam1@oldwestbury.edu","121793");
                   }
               
              }
              
           
              
              );

      try{
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("Late Penalty!");

         // Now set the actual message
         message.setText("Dear Member, You have been fined $10 for not submitting the book on due date");

         // Send message
         Transport.send(message);
         
         System.out.println("Sent message successfully....");
         
      }
      catch (MessagingException mex) {
         mex.printStackTrace();
      }

                       
        /*
         // Recipient's email ID needs to be mentioned.
      String to = "k122261@nu.edu.pk";

      // Sender's email ID needs to be mentioned
      String from = "aimam1@oldwestbury.edu";

      // Assuming you are sending email from localhost
      
      // Get system properties
      Properties properties = new Properties();

      // Setup mail server
      properties.put("mail.smtp.host","smtp.gmail.com");
      properties.put("mail.smtp.socketFactory.port","465");
      properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
      properties.put("mail.smtp.auth","true");
      properties.put("mail.smtp.","465");

     // Get the default Session object.
      Session session = Session.getDefaultInstance(properties,   
              
              new javax.mail.Authenticator() {
                  
                  protected PasswordAuthentication getPasswordAuthentication()
                   {
                     return new PasswordAuthentication("aimam1@oldwestbury.edu","121793");
                   }
               
              }
              
           
              
              );

      try{
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("Late Penalty!");

         // Now set the actual message
         message.setText("Dear Member, You have been fined $10 for not submitting the book on due date");

         // Send message
         Transport.send(message);
         
         System.out.println("Sent message successfully....");
         
      }
      catch (MessagingException mex) {
         mex.printStackTrace();
      }

*/
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         
        connect();
        try{  
             statement=con.createStatement();
              
        if(searchbooks.getSelectedItem().toString().equals("ISBN"))
           {
                rs=statement.executeQuery("select *from people.books where isbn='"+searchbookstext.getText()+"'");
                 displaybooks(rs);
           }
           else if(searchbooks.getSelectedItem().toString().equals("Year"))
           {
               
                rs=statement.executeQuery("select *from people.books where year='"+searchbookstext.getText()+"'");
                          displaybooks(rs);                                  
                         
            
           }
           else if(searchbooks.getSelectedItem().toString().equals("Title"))
           {
               
                rs=statement.executeQuery("select *from people.books where title='"+searchbookstext.getText()+"'");
                          displaybooks(rs);                                  
                         
            
           }
          else if(searchbooks.getSelectedItem().toString().equals("Author"))
           {
               
                rs=statement.executeQuery("select *from people.books where genre='"+searchbookstext.getText()+"'");
                          displaybooks(rs);                              
                         
            
           }
          else if(searchbooks.getSelectedItem().toString().equals("Genre"))
           {
               
                rs=statement.executeQuery("select *from people.books where author='"+searchbookstext.getText()+"'");
                          displaybooks(rs);                              
                         
            
           }
          
        
        }
        catch(SQLException se){se.printStackTrace();}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        connect();
            BookDefaultTable.setRowCount(0);
        try{
            call=con.prepareCall("call display_all_books()");
     
            call.executeQuery();
          
            rs=call.getResultSet();
          
          while(rs.next())
          {
      
    BookDefaultTable.insertRow(BookDefaultTable.getRowCount(),new Object[]
         {rs.getString("isbn"),rs.getString("title"),rs.getString("genre"),rs.getString("author"),rs.getString("year"),
          rs.getBoolean("availability") });
          
    
         }
         
            tabpane.setSelectedIndex(3);
 
        }
        catch(SQLException se){se.printStackTrace();}        
    }//GEN-LAST:event_jButton5ActionPerformed

    public void displaybooks(ResultSet rs)
{
    BookDefaultTable.setRowCount(0);

        try {
            while(rs.next())
            {
                BookDefaultTable.insertRow(BookDefaultTable.getRowCount(),new Object[]{rs.getString("isbn"),
                
                rs.getString("title"),rs.getString("genre"),rs.getString("author"),rs.getString("year"),rs.getBoolean("availability")});
               
            }       
        tabpane.setSelectedIndex(4);
            
        } catch (SQLException ex) {
            Logger.getLogger(BookCollectionSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    public void connect()
{
        try {
            Class.forName("com.mysql.jdbc.Driver");
             System.out.println("Driver found");
            } 
        catch (ClassNotFoundException ex) {
            }
    
    
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/people","root","rafa2012");
            
            System.out.println("Connection successful");
             }
        catch (SQLException ex) {
          
            ex.printStackTrace();
        }        


}
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException, ParseException  {
      
        
        UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
        
        //</editor-fold>
                   
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
               new BookCollectionSystem(null).setVisible(true);
            }
        });
    }
    
  /*  public void save()
    {
    
        try {
            prepare=con.prepareStatement("insert into people.student(name,id,phone_number,address,city,year,membership) values(?,?,?,?,?,?,?)");
        
            
            prepare.setString(1,studentname.getText());
            prepare.setString(2,studentidentity.getText());
            prepare.setString(3,phonenumber.getText());
            prepare.setString(4,addresstext.getText());
            prepare.setString(5,studentcity.getSelectedItem().toString());
            prepare.setString(6,studentyear.getSelectedItem().toString());
            prepare.setBoolean(7,membership.isSelected());
            
            
            
            int row=prepare.executeUpdate();
            System.out.println("Rows affected");
        }
        catch(SQLException se){se.printStackTrace();}
               
    */
    
    
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane OptionPanel;
    private javax.swing.JComboBox<String> alpha;
    private javax.swing.JLabel authortext;
    private javax.swing.JTable availablebooks;
    private javax.swing.JTextField bookauthor;
    private javax.swing.JTextField bookname;
    private javax.swing.JTable booktable;
    private javax.swing.JTextField booktitle;
    private javax.swing.JComboBox<String> bookyear;
    private javax.swing.JTable checkoutbooks;
    private javax.swing.JMenu filemenu;
    private javax.swing.JLabel genreitem;
    private javax.swing.JList<String> genrelist;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel name;
    private javax.swing.JComboBox<String> searchbooks;
    private javax.swing.JTextField searchbookstext;
    private javax.swing.JTextField searchtext;
    private javax.swing.JLabel selectstudentlabel;
    private javax.swing.JTable studenttabel;
    private javax.swing.JLabel titletext;
    private javax.swing.JTabbedPane verticaltabbedpanel;
    private javax.swing.JLabel yeartext;
    // End of variables declaration//GEN-END:variables
}
