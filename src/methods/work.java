package methods;

/*
 * ����ʱ���
 */
public class work {
	 public Object name;
	 public Object arrival_time;
	 public Object in_time;
	 public Object start_time;
	 public Object over_time;
	 public Object state;//0Ϊ�ա�1Ϊ��װ��,2Ϊ�Ѿ�����
	 public Object avgtime;
	 public Object    id;
   public work() {
      name="job";
	   arrival_time="0:0";
	   in_time="0:0";
	   start_time="0:0";
	   over_time="0:0";
	   avgtime=0;
	   state=0;
	   id=0;
   }
}