
import java.util.Date;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;



public class Main {

	public static void main(String[] args) throws Exception {		
		long start = new Date().getTime();		
		Configuration conf = new Configuration();
		
	     Job job = Job.getInstance();
	     job.setJarByClass(Volatile_phase1.class);
	     Job job2 = Job.getInstance();
	     job2.setJarByClass(Volatile_phase2.class);
	     Job job3 = Job.getInstance();
	     job3.setJarByClass(Volatile_phase3.class);
		 

		System.out.println("\n**********Volatility_Hadoop-> Start**********\n");

		job.setJarByClass(Volatile_phase1.class);
		job.setMapperClass(Volatile_phase1.Map1.class);
		job.setReducerClass(Volatile_phase1.Reduce1.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		job.setNumReduceTasks(10);

	}
}

