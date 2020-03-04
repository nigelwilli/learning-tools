package dev.innov8.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.innov8.models.Role;
import dev.innov8.models.User;
import dev.innov8.web.Handler;
import dev.innov8.web.HandlerContext;
import dev.innov8.web.annotations.Controller;

@Controller(
	name="UserController",
	uri="/users",
	qualifiedName="dev.innov8.web.controllers.UserController"
)
public class UserController implements Handler {

	/**
	 * Currently returning dummy values.
	 */
	@Override
	public Object invoke(HandlerContext hctx, HttpServletRequest req, HttpServletResponse resp) {
		List<User> users = new ArrayList<>();
		users.add(new User(1, "wsingleton", "p4ssw0rd", "Wezley", "Singleton", Role.ADMIN));
		users.add(new User(2, "skelsey", "rocky", "Steven", "Kelsey", Role.DEV));
		users.add(new User(3, "bkruppa", "javascript", "Blake", "Kruppa", Role.USER));
		users.add(new User(4, "tchester", "origin", "Trevin", "Chester", Role.USER));
		hctx.setDone(true);
		return users;
	}

}
