import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Editor extends JFrame implements ActionListener
{
	String filename = "";
	String path = "";
	JFileChooser filechooser = new JFileChooser(System.getProperty("user.dir"));
	JMenuBar menubar = new JMenuBar();
	JMenuItem open = new JMenuItem("Open");
	JMenuItem save = new JMenuItem("Save");
	JMenuItem saveas = new JMenuItem("Save As");
	JMenuItem quit = new JMenuItem("Quit");
	JTextArea document = new JTextArea(32,80);
	JScrollPane documentview = new JScrollPane(document,
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	public Editor()
	{
		createWindow();
		addMenuListeners();
	}
	
	private void addMenuListeners()
	{
		open.addActionListener(this);
		save.addActionListener(this);
		saveas.addActionListener(this);
		quit.addActionListener(this);
	}
		
	private void createWindow()
	{
		setFont(new Font("SansSerif",Font.PLAIN,12));
		document.setFont(new Font("Monospaced",Font.PLAIN,12));
		setTitle("Editor");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(documentview);
		createMenuBar();
		setJMenuBar(menubar);
		pack();
		setVisible(true);
	}
	
	private void createMenuBar()
	{
		JMenu filemenu = new JMenu("File");
		filemenu.add(open);
		filemenu.add(save);
		filemenu.add(saveas);
		filemenu.add(quit);		
		menubar.add(filemenu);
		
		save.setEnabled(false); // can't save without a filename
		
	}
	
	public void actionPerformed(ActionEvent e)
	{

		if(e.getSource() == open)
		{
			filechooser.setApproveButtonText("Open");
			if(setFilename())
				open();
		}
		else if(e.getSource() == save)
		{
			save();
		}
		else if(e.getSource() == saveas)
		{
			filechooser.setApproveButtonText("Save");
			if(setFilename())
				save();
			
		}
		else if(e.getSource() == quit)
		{
			System.exit(0);
		}
		
	}

	private boolean setFilename()
	{
	    int returnVal = filechooser.showOpenDialog(this);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       filename = filechooser.getSelectedFile().getName();
	       path = filechooser.getSelectedFile().getAbsolutePath();
	       save.setEnabled(true);
	       setTitle("Editor - " + filename);
	       return true;
	    }
	    return false;
	}
	
	private void open()
	{
		try {
			FileReader r = new FileReader(path);
			document.read(r,null);
		} catch(IOException e) {}
	}
	
	private void save()
	{
		System.out.println(filename);
		try {
			FileWriter r = new FileWriter(path);
			document.write(r);
		} catch(IOException e) {}		
	}
	
	public static void main(String[] args)
	{
		new Editor();
	}
}