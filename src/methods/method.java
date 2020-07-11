package methods;



public class method {

	public class work {
		 public Object name;
		 public Object arrival_time;
		 public Object in_time;
		 public Object start_time;
		 public Object over_time;
		 public int    avgtime;
	    public work() {
	       name="job";
		   arrival_time="0:0";
		   in_time="0:0";
		   start_time="0:0";
		   over_time="0:0";
		   avgtime=0;
	    }
	}
	
	/*
	 *判断两个作业的先后 
	*/
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
		return false;
		
	}
	/*
	 * 先来先服务作业调度算法
	 */
	public job FCFS (job[] jobs) {
		job min=jobs[0];
		for(int i=0;i<jobs.length;i++) {
			if(Integer.parseInt((String)jobs[i].state)==0) {min=jobs[i]; break;}
		}
		for(int i=1;i<jobs.length;i++) {
			if(Integer.parseInt((String)jobs[i].state)==0){
			if(before(min,jobs[i])) min=jobs[i];
		    }
		}
		return min;
	}
	/*
	 *短作业优先作业调度 
	 */
	public job SJF(job[] jobs) {
		job min=jobs[0];
		for(int i=0;i<jobs.length;i++) {
			if(Integer.parseInt((String)jobs[i].state)==0) {min=jobs[i]; break;}
		}
		for(int i=1;i<jobs.length;i++) {
			if(Integer.parseInt((String)jobs[i].state)==0){
			if(Integer.parseInt((String)min.word_time)>Integer.parseInt((String)jobs[i].word_time)) min=jobs[i];
		    }
		}
		return min;
	}
	
	}

