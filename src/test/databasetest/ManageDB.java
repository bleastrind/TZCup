package test.databasetest;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
@SuppressWarnings("unchecked")
public class ManageDB { 
private SessionFactory sessionFactory; 
@SuppressWarnings("unused")
private Session session; 

{ 
try { 
sessionFactory = new Configuration().configure().buildSessionFactory(); 
session = sessionFactory.openSession(); 
} catch (Exception e) { 
e.printStackTrace(); 
System.exit(1); 
} 
} 

public void execute() { 
Configuration conf = new Configuration().configure("hibernate.cfg.xml"); 
SchemaExport dbExport=new SchemaExport(conf); 
dbExport.setOutputFile("D:/tzcup.sql");
SchemaExport.main(null);
dbExport.create(true, true); 
} 

public static void main(String[] args){ 
ManageDB db =new ManageDB(); 
db.execute(); 
} 
} 