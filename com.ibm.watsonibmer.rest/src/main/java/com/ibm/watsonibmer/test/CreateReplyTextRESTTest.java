package com.ibm.watsonibmer.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.ibm.watsonibmer.domain.ReplyText;
import com.ibm.watsonibmer.service.SlackSlashCommandService;

public class CreateReplyTextRESTTest {

	public static void main(String args[]) {
		ReplyText r = null;
		String name = "search-crawl-status";
		SlackSlashCommandService service = new SlackSlashCommandService();
		r = service.find(ReplyText.class, name);
		if(r == null) {
			r = new ReplyText();
		}
		
		SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		r.setName(name);
		r.setText(""
				+ "Status Report Time: " + format1.format(Calendar.getInstance().getTime()) + "\n"
				+ "Lease Owner: LCW3Cell01\\b03zciwas190\\ICSearch190\n"
				+ "Search Node:              Crawl Version  Crawl Date           Current Time         Delta   Formatted Delay                            Delay In Minutes\n"
				+ "b03zciwas188:ICSearch188: 1477576740486: 2016-10-27 09:59:00: 2016-10-27 10:29:17: 1816792 0 days, 0 hours, 30 minutes, 16 seconds. | Delay in minutes: 30\n"
				+ "b03zciwas191:ICSearch191: 1477576740486: 2016-10-27 09:59:00: 2016-10-27 10:29:17: 1816792 0 days, 0 hours, 30 minutes, 16 seconds. | Delay in minutes: 30\n"
				+ "b03zciwas192:ICSearch192: 1477576740486: 2016-10-27 09:59:00: 2016-10-27 10:29:17: 1816792 0 days, 0 hours, 30 minutes, 16 seconds. | Delay in minutes: 30\n"
				+ "b03zciwas190:ICSearch190: 1477576740486: 2016-10-27 09:59:00: 2016-10-27 10:29:17: 1816792 0 days, 0 hours, 30 minutes, 16 seconds. | Delay in minutes: 30\n"
				+ "b03zciwas193:ICSearch193: 1477576740486: 2016-10-27 09:59:00: 2016-10-27 10:29:17: 1816792 0 days, 0 hours, 30 minutes, 16 seconds. | Delay in minutes: 30\n"
				+ "b03zciwas189:ICSearch189: 1477576740486: 2016-10-27 09:59:00: 2016-10-27 10:29:17: 1816792 0 days, 0 hours, 30 minutes, 16 seconds. | Delay in minutes: 30\n"
				);
		System.out.println("length: " + r.getText().length());
		service.save(r);
		
	}
	
}
