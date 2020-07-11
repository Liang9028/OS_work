package methods;
/*
 * 作业表
 */
public class job {
    public Object name;
    public Object arrival_time;
    public Object    word_time;
    public Object    memory;
    public Object    drive;
    public Object    state;
    public Object    id;
  public job(){
  	  name="job";
	      arrival_time="0:0";
	      word_time=0;
	      memory=0;
	      drive=0;
	      state=-1;//0为输入井，1为已写入内存，2为执行完毕
	      id=0;
    }
}