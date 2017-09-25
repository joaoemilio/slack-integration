package slack.controller;

import com.amazonaws.services.ec2.model.StopInstancesRequest;
import com.ibm.watsonibmer.domain.ReplyText;
import com.ibm.watsonibmer.service.SlackSlashCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.net.InetAddress;
import java.util.Iterator;
import java.util.List;

/**
 * @author joaoemilio
 *
 */

@RestController
@RequestMapping("/api/slack")
public class SlackRESTController {

	private static final Logger log = LoggerFactory.getLogger(SlackRESTController.class);

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String command(WebRequest request) {
		SlackSlashCommandService service = new SlackSlashCommandService();

		Iterator<String> it = request.getParameterNames();
		while( it.hasNext() ) {
			String param = it.next();
			log.info( param + " " + request.getParameterValues(param));
		}

		StopInstancesRequest aws = new StopInstancesRequest().withInstanceIds("i-058f3f1830f64c8af");

		return "OK";
	}

}
