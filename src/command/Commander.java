package command;
import javax.servlet.http.HttpServletRequest;
import enums.Action;

public class Commander {
	public static Command order(HttpServletRequest request){
			Command cmd =null;
			switch(Action.valueOf(request.getParameter("action").toUpperCase())) {
			case ADD : 
				System.out.println("----Commander에 Case의  ADD 진입----");
				cmd = new AddCommand(request);
			case SEARCH : 
				System.out.println("----Commander에 Case의  SEARCH 진입----");
				cmd = new SearchCommand(request);
				break;
			case RETRIEVE : 
				System.out.println("----Commander에 Case의  RETRIEVE 진입----");
				cmd = new RetrieveCommand(request);
				break;
			case COUNT : 
				System.out.println("----Commander에 Case의  COUNT 진입----");
				cmd = new CountCommand(request);
				break;
			case MODIFY : 
				System.out.println("----Commander에 Case의  MODIFY 진입----");
				cmd = new ModifyCommand(request);
				break;
			case REMOVE : 
				System.out.println("----Commander에 Case의  REMOVE 진입----");
				cmd = new RemoveCommand(request);
				break;
			case LOGIN : 
				System.out.println("----Commander에 Case의 LOGIN 진입----");
				cmd = new LoginCommand(request);
				break;
			case MOVE : 
				System.out.println("----Commander에 Case의  MOVE 진입----");
				cmd = new MoveCommand(request);
				break;
			case FILEUPLOAD :  
				cmd = new MoveCommand(request);
				break;
			default:
				break;
			}
			return cmd;
	}
}
