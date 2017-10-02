package controller.command.authentication;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import config.ConfigurationManager;
import config.MessageManager;
import controller.command.ActionCommand;
import model.entity.Client;
import model.entity.User;
import model.service.RegistrationService;

public class RegistrationCommand implements ActionCommand {
	private static final Logger LOGGER = Logger.getLogger(RegistrationCommand.class.getSimpleName());
	private RegistrationService clientService;
	
	public RegistrationCommand(RegistrationService service){
		clientService = service;
	}
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		
		if (parametersHandler(request)) {
			request.setAttribute("successRegistration", MessageManager.getProperty("register.success"));
			page = ConfigurationManager.getProperty("path.page.login");
			LOGGER.info("The user registered successfully.");
		} else {
			request.setAttribute("wrongRegistration", MessageManager.getProperty("register.fail"));
			page = ConfigurationManager.getProperty("path.page.registration");
			LOGGER.info("The user entered incorrect data during registration.");
		}
		return page;
	}

	private boolean parametersHandler(HttpServletRequest request) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String passportId = request.getParameter("passportId");

		if (clientService.checkByEmailAndPassportId(email, passportId)) {
			return false;
		} else {
			User user = createUser(email, password);
			Client client = createClient(firstName, middleName, lastName, passportId);
			
			clientService.registerClient(user, client);
			return true;
		}
	}
	
	private User createUser(String email, String password){
		return  new User.Builder()
				.setEmail(email)
				.setPassword(password)
				.build();
	}
	
	private Client createClient(String firstName, String middleName, String lastName, String passportId){
		return  new Client.Builder()
				.addFirstName(firstName)
				.addMiddleName(middleName)
				.addLastName(lastName)
				.addPassportId(passportId)
				.build();
	}
}
