package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import methods.method;
import methods.work;

import methods.job;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class Window extends JFrame {

	private JPanel contentPane;
	private JTable gongzuo_table;
	private JTable work_table;
	private String time="0:0";
	private job[]  jobs=new job[5];
	private work[] works=new work[5];
	private JLabel time_text;
	private method m=new method();
	private int sum=4;
	private int op=0;
	private JComboBox zuoye;
	private JComboBox jincheng;
	private int neicun=100;
	private JLabel neicun_text;
	private JLabel chidaiji_text;
	private int w=0;
	private boolean running=false;
	private String runer;
	private JLabel runer_text;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 576);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		gongzuo_table = new JTable();
		gongzuo_table.setModel(new DefaultTableModel(
			new Object[][] {
				{"JOB1", "10:00", new Integer(25), new Integer(15), new Integer(2)},
				{"JOB2", "10:20", new Integer(30), new Integer(60), new Integer(1)},
				{"JOB3", "10:30", new Integer(10), new Integer(50), new Integer(3)},
				{"JOB4", "10:35", new Integer(20), new Integer(10), new Integer(2)},
				{"JOB5", "10:40", new Integer(15), new Integer(30), new Integer(2)},
			},
			new String[] {
				"\u4F5C\u4E1A\u540D", "\u5230\u8FBE\u65F6\u95F4", "\u8FD0\u884C\u65F6\u95F4", "\u6240\u9700\u5185\u5B58", "\u6240\u9700\u78C1\u5E26\u673A"
			}
		));
		gongzuo_table.getColumnModel().getColumn(0).setPreferredWidth(80);
		
		JLabel lblNewLabel = new JLabel("\u4F5C\u4E1A\u540D");
		lblNewLabel.setFont(new Font("华文中宋", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("\u5230\u8FBE\u65F6\u95F4");
		lblNewLabel_1.setFont(new Font("华文中宋", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2 = new JLabel("\u8FD0\u884C\u65F6\u95F4/\u5206");
		lblNewLabel_2.setFont(new Font("华文中宋", Font.PLAIN, 15));
		
		JLabel lblNewLabel_3 = new JLabel("\u6240\u9700\u5185\u5B58/KB");
		lblNewLabel_3.setFont(new Font("华文中宋", Font.PLAIN, 15));
		
		JLabel lblNewLabel_4 = new JLabel("\u6240\u9700\u78C1\u5E26\u673A /\u53F0");
		lblNewLabel_4.setFont(new Font("华文中宋", Font.PLAIN, 15));
		
		 zuoye = new JComboBox();
		zuoye.setModel(new DefaultComboBoxModel(new String[] {"\u5148\u6765\u5148\u670D\u52A1\u7B97\u6CD5", "\u6700\u5C0F\u4F5C\u4E1A\u4F18\u5148\u7B97\u6CD5"}));
		
		 jincheng = new JComboBox();
		jincheng.setModel(new DefaultComboBoxModel(new String[] {"\u5148\u6765\u5148\u670D\u52A1\u7B97\u6CD5", "\u6700\u77ED\u8FDB\u7A0B\u4F18\u5148\u7B97\u6CD5"}));
		
		JLabel lblNewLabel_5 = new JLabel("\u4F5C\u4E1A\u8C03\u5EA6\u7B97\u6CD5");
		
		JLabel lblNewLabel_6 = new JLabel("\u8FDB\u7A0B\u8C03\u5EA6\u7B97\u6CD5");
		
		work_table = new JTable();
		work_table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"\u4F5C\u4E1A\u540D", "\u5230\u8FBE\u65F6\u95F4", "\u8FDB\u5165\u5185\u5B58\u65F6\u95F4", "\u5F00\u59CB\u65F6\u95F4", "\u7ED3\u675F\u65F6\u95F4", "\u5E26\u6743\u5468\u8F6C\u65F6\u95F4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		work_table.getColumnModel().getColumn(0).setResizable(false);
		work_table.getColumnModel().getColumn(1).setResizable(false);
		work_table.getColumnModel().getColumn(2).setResizable(false);
		work_table.getColumnModel().getColumn(3).setResizable(false);
		work_table.getColumnModel().getColumn(3).setPreferredWidth(89);
		work_table.getColumnModel().getColumn(4).setResizable(false);
		work_table.getColumnModel().getColumn(5).setResizable(false);
		work_table.getColumnModel().getColumn(5).setPreferredWidth(93);
		
		JLabel lblNewLabel_7 = new JLabel("\u4F5C\u4E1A\u540D");
		
		JLabel lblNewLabel_8 = new JLabel("\u5230\u8FBE\u65F6\u95F4");
		
		JLabel lblNewLabel_9 = new JLabel("\u8FDB\u5165\u5185\u5B58\u65F6\u95F4");
		
		JLabel lblNewLabel_10 = new JLabel("\u5F00\u59CB\u65F6\u95F4");
		
		JLabel lblNewLabel_11 = new JLabel("\u5468\u8F6C\u65F6\u95F4");
		
		JLabel lblNewLabel_12 = new JLabel("\u7ED3\u675F\u65F6\u95F4");
		
		JLabel lblNewLabel_13 = new JLabel("\u5185\u5B58\u7A7A\u95F4\uFF1A100KB");
		
		JLabel lblNewLabel_14 = new JLabel("\u78C1\u5E26\u673A\u6570\uFF1A4");
		
		JButton btnNewButton = new JButton("\u5F00\u59CB");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kaishi(e);
			}

		
		});
		
		time_text = new JLabel("\u672A\u5F00\u59CB");
		
		JButton btnNewButton_1 = new JButton("\u524D\u8FDB\u4E94\u5206\u949F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qianjin(e);
			}

			private void qianjin(ActionEvent e) {
				String[] s=time.split("\\:");
				int a= Integer.parseInt(s[1])+5;
				if(a/60>=1) time=String.valueOf(Integer.parseInt(s[0])+1)+":"+String.valueOf(a-60);
				else time=s[0]+":"+String.valueOf(a);
				time_text.setText("现在的时间是："+time); 
				for(int i=0 ;i<jobs.length;i++) {
					System.out.println(works[i].name+"  "+works[i].arrival_time+"  "+works[i].id+"  "+works[i].in_time+"  "+works[i].over_time+"  "+jobs[i].state);
					
				}
				System.out.println(neicun);

				System.out.println("---------------------------------------------");
				switch(op) {
				   case 00 :
				             check();
				             FCFS(jobs);
				             if(!running) FCFSwork(jobs);
				             FCFS(jobs);
				             break;
				   case 01 :
				             check();
				             FCFS(jobs);
				             if(!running) SJFwork(jobs);
				             FCFS(jobs);
				             break;
				   case 10 : 
				             check();
				             SJF(jobs);
				             if(!running) FCFSwork(jobs);
				             SJF(jobs);
				             
				             break;
				   case 11 :
				             SJF(jobs);
				             if(!running) SJFwork(jobs);
				             check();
				             SJF(jobs);
				            
				             break;
					    
				  }
				
			}
		});
		
		 neicun_text = new JLabel("\u672A\u5F00\u59CB");
		
		 chidaiji_text = new JLabel("\u672A\u5F00\u59CB");
		
		JButton btnNewButton_2 = new JButton("\u91CD\u7F6E");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset(e);
			}

			private void reset(ActionEvent e) {
				for(int i=0;i<jobs.length;i++) {
					jobs[i].state=-1;
				}
				runer="";
				op=0;
				sum=4;
				neicun=100;
				time_text.setText("未开始"); 
				 neicun_text.setText("未开始");
				 chidaiji_text.setText("未开始");
				 runer_text.setText("未开始");
				 work_table.setModel(new DefaultTableModel(
							new Object[][] {
								{null, null, null, null, null, null},
								{null, null, null, null, null, null},
								{null, null, null, null, null, null},
								{null, null, null, null, null, null},
								{null, null, null, null, null, null},
							},
							new String[] {
								"\u4F5C\u4E1A\u540D", "\u5230\u8FBE\u65F6\u95F4", "\u8FDB\u5165\u5185\u5B58\u65F6\u95F4", "\u5F00\u59CB\u65F6\u95F4", "\u7ED3\u675F\u65F6\u95F4", "\u5E26\u6743\u5468\u8F6C\u65F6\u95F4"
							}
						));
				 w=0;
			}
		});
		
		 runer_text = new JLabel("\u672A\u5F00\u59CB");
		
		JLabel lblNewLabel_15 = new JLabel("\u9884\u8F93\u5165\u53EF\u4FEE\u6539");
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(gongzuo_table, GroupLayout.PREFERRED_SIZE, 539, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(lblNewLabel_15, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(time_text, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(53)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(136)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(chidaiji_text, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(neicun_text, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(runer_text, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(23)
											.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
											.addGap(27)
											.addComponent(lblNewLabel_9)
											.addGap(18)
											.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
											.addGap(40)
											.addComponent(lblNewLabel_12, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
											.addGap(29)
											.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(lblNewLabel_5)
													.addGap(10)
													.addComponent(zuoye, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
												.addComponent(lblNewLabel_14, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
											.addGap(78)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_13, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(lblNewLabel_6)
													.addGap(10)
													.addComponent(jincheng, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))))))
								.addComponent(work_table, GroupLayout.PREFERRED_SIZE, 552, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(82, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(38)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(1)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_4))
							.addGap(6)
							.addComponent(gongzuo_table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(100)
							.addComponent(lblNewLabel_15)))
					.addGap(49)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(zuoye, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(9)
							.addComponent(lblNewLabel_6))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(jincheng, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_14)
						.addComponent(lblNewLabel_13))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(time_text, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_1)
							.addComponent(btnNewButton_2)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(neicun_text)
							.addGap(14)
							.addComponent(chidaiji_text)
							.addGap(40)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_7)
								.addComponent(lblNewLabel_8)
								.addComponent(lblNewLabel_9)
								.addComponent(lblNewLabel_10)
								.addComponent(lblNewLabel_12)
								.addComponent(lblNewLabel_11))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(38)
							.addComponent(runer_text)))
					.addComponent(work_table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	public boolean before(job job1,job job2){
		String a[]=job1.arrival_time.toString().split("\\:");
		String b[]=job2.arrival_time.toString().split("\\:");
		if(Integer.parseInt(a[0])<Integer.parseInt(b[0]))  return true;
		else if(Integer.parseInt(a[0])>Integer.parseInt(b[0])) return false;
		else if(Integer.parseInt(a[0])==Integer.parseInt(b[0]))
		{
			if(Integer.parseInt(a[1])<Integer.parseInt(b[1])) return true;
			if(Integer.parseInt(a[1])>Integer.parseInt(b[1])) return false;
			
		}
		return true;
		
	}
	public String  mini(job[] jobs) {
		job Mini=jobs[0];
		for(int i=1;i<jobs.length;i++) {
			if(!before(Mini,jobs[i])) Mini=jobs[i];
		}
		return Mini.arrival_time.toString();
	}
	public  boolean  mini(job job1,job[] jobs) {
		for(int i=0;i<jobs.length;i++) {
			if(Integer.parseInt(jobs[i].state.toString())==0) {
			if(!before(job1,jobs[i])) return false;
		}
		} return true;
	}
	public  boolean Mini(job job1,job[] jobs) {
		for(int i=0;i<jobs.length;i++) {
			if(Integer.parseInt(jobs[i].state.toString())==0) {
			if(Integer.parseInt(jobs[i].word_time.toString())<Integer.parseInt(job1.word_time.toString())) return false;
		}
		}	
		return true;
	}
	public void kaishi(ActionEvent e) {
	    
		for(int i=0;i<gongzuo_table.getRowCount();i++) {
		
		jobs[i]= new job();
		jobs[i].name=gongzuo_table.getModel().getValueAt(i,0);
		jobs[i].arrival_time=gongzuo_table.getModel().getValueAt(i,1);
		jobs[i].word_time=gongzuo_table.getModel().getValueAt(i,2);
		jobs[i].memory=gongzuo_table.getModel().getValueAt(i,3);
        jobs[i].drive=gongzuo_table.getModel().getValueAt(i,4);
        jobs[i].id=i+1;
        
	}
	  time=mini(jobs);
	  for(int i=0;i<gongzuo_table.getRowCount();i++) {
			works[i]= new work();
		}	
	  
	  op=zuoye.getSelectedIndex()*10+jincheng.getSelectedIndex();
	  switch(op) {
	   case 00 : 
	             check();
	             FCFS(jobs);
	             if(!running) FCFSwork(jobs);
	             FCFS(jobs);
	             break;
	   case 01 : 
	             check();
	             FCFS(jobs);
	             if(!running) SJFwork(jobs);
	             FCFS(jobs);
	             break;
	   case 10 : 
	             check();
	             SJF(jobs);
	             if(!running) FCFSwork(jobs);
	             SJF(jobs);
	             break;
	   case 11 : 
	             check();
	             SJF(jobs);
	             if(!running) SJFwork(jobs);
	             SJF(jobs);
	             break;
		    
	  }
      write();
	  
	}
    /*
              * 先来先服务作业调度
     */
	private void FCFS(job[] jobs) {
	  for(int i=0;i<jobs.length;i++) {
		 if(mini(jobs[i],jobs)&&before(jobs[i].arrival_time.toString(),time) && sum-Integer.parseInt(jobs[i].drive.toString())>=0 && neicun-Integer.parseInt(jobs[i].memory.toString())>=0 && Integer.parseInt(jobs[i].state.toString())==0) {
		       jobs[i].state=1;  sum=sum-Integer.parseInt(jobs[i].drive.toString()); neicun	= neicun-Integer.parseInt(jobs[i].memory.toString()); in(jobs[i]); write();
		 }
		 }
	    
	  }
	/*
	 * 短作业优先调度
	 */
	private void SJF(job[] jobs) {
		for(int i=0;i<jobs.length;i++) {
			 if(Mini(jobs[i],jobs)&&before(jobs[i].arrival_time.toString(),time) && sum-Integer.parseInt(jobs[i].drive.toString())>=0 && neicun-Integer.parseInt(jobs[i].memory.toString())>=0 && Integer.parseInt(jobs[i].state.toString())==0) {
			       jobs[i].state=1;  sum=sum-Integer.parseInt(jobs[i].drive.toString()); neicun	= neicun-Integer.parseInt(jobs[i].memory.toString()); in(jobs[i]); write();
			 }
			 }
		    
		  }	
	/*
	 * 先来先服务进程调度
	 */	
	private void FCFSwork(job[] jobs) {
		for(int i=0;i<jobs.length;i++) {
			 if(Integer.parseInt(jobs[i].state.toString())==1) {
			    if(first(works[find(jobs[i])],works)) {
			    	jobs[i].state=2; works[find(jobs[i])].start_time=time; works[find(jobs[i])].state=2;
			    	running=true; runer=jobs[i].name.toString(); return;
			    }
			 }
			 }
		    
		  }	
	/*
	 * 短进程优先进程调度
	 */
	private void SJFwork(job[] jobs) {
		for(int i=0;i<jobs.length;i++) {
			 if(Integer.parseInt(jobs[i].state.toString())==1) {
			    if(First(jobs[i],jobs)) {
			    	jobs[i].state=2; works[find(jobs[i])].start_time=time; works[find(jobs[i])].state=2;
			    	running=true;  runer=jobs[i].name.toString();  return;
			    }
			 }
			 }
	}
	public void check() {
		for(int i=0;i<jobs.length;i++) {
			if(before(jobs[i].arrival_time.toString(),time)&&Integer.parseInt(jobs[i].state.toString())==-1)  jobs[i].state=0;
			if(Integer.parseInt(jobs[i].state.toString())==2) {
			   String[]  	a=works[find(jobs[i])].start_time.toString().split("\\:");
			   String[]  	b=time.split("\\:");
			   String[]     c=jobs[i].arrival_time.toString().split("\\:");
			   if(Integer.parseInt(b[0])*60+Integer.parseInt(b[1])-(Integer.parseInt(a[0])*60+Integer.parseInt(a[1]))==Integer.parseInt(jobs[i].word_time.toString())) {
				   jobs[i].state=3; works[find(jobs[i])].state=3; works[find(jobs[i])].over_time=time; works[find(jobs[i])].avgtime=(Integer.parseInt(b[0])*60+Integer.parseInt(b[1])-(Integer.parseInt(c[0])*60+Integer.parseInt(c[1])));
			       set(jobs[i]); 
			       sum=sum+Integer.parseInt(jobs[i].drive.toString());
			       neicun=neicun+Integer.parseInt(jobs[i].memory.toString());
			       running=false;
			   }
				   
			}
		}
		
	}
	public boolean First(job job1,job[] jobs) {
		for(int i=0;i<jobs.length;i++) {
			if(Integer.parseInt(jobs[i].state.toString())==1) {
			if(Integer.parseInt(jobs[i].word_time.toString())<Integer.parseInt(job1.word_time.toString())) return false;
		}
		}	
		return true;
	}
	
	
	public boolean first(work work1,work [] works ) {
		for(int i=0;i<works.length;i++) {
			if(Integer.parseInt(works[i].state.toString())==1) {
			if(!before(work1.in_time.toString(),works[i].in_time.toString())) return false; 
		}
		}	
		return true;
	}

	public boolean before(String time1,String time2){
			String a[]=time1.split("\\:");
			String b[]=time2.split("\\:");
			if(Integer.parseInt(a[0])<Integer.parseInt(b[0]))  return true;
			else if(Integer.parseInt(a[0])>Integer.parseInt(b[0])) return false;
			else if(Integer.parseInt(a[0])==Integer.parseInt(b[0]))
			{
				if(Integer.parseInt(a[1])<Integer.parseInt(b[1])) return true;
				if(Integer.parseInt(a[1])>Integer.parseInt(b[1])) return false;
				
			}
			return true;	
	}
	  private int find(job job) {
		for(int i=0;i<works.length;i++) {
			if(Integer.parseInt(works[i].id.toString())==Integer.parseInt(job.id.toString())) return i;
		}
		return 0;	
		}
	  
	 public void write() {
		 time_text.setText("现在的时间是："+time); 
		 neicun_text.setText("剩余内存："+neicun+"KB");
		 chidaiji_text.setText("剩余磁带机："+sum+"台");
		 runer_text.setText("正在运行的是："+runer);
	 }
	 public void set(job job1) {
	  	 work_table.setValueAt(works[find(job1)].name, w, 0);
	  	 work_table.setValueAt(works[find(job1)].arrival_time, w, 1);
	  	 work_table.setValueAt(works[find(job1)].in_time, w, 2);
	  	 work_table.setValueAt(works[find(job1)].start_time, w, 3);
	  	 work_table.setValueAt(works[find(job1)].over_time, w, 4);
	  	 work_table.setValueAt(works[find(job1)].avgtime, w, 5);
	  	 w++;
	  	 
	 }
	 public void in(job job1) {
		 for(int i=0;i<works.length;i++) {
			 if(Integer.parseInt(works[i].state.toString())==0) {
				 works[i].name=job1.name; works[i].arrival_time=job1.arrival_time;
				 works[i].in_time=time;   works[i].state=1; works[i].id=job1.id;
				 return;
			 }
		 }
	 }
}
