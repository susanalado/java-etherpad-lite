package net.gjerull.etherpad.client;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;


@GraphWalker(value = "random(edge_coverage(100))", start = "setUp")
public class EPLiteClientPadsTest extends ExecutionContext implements EPLiteClientPadsInterface  {

//	public void setUp() {
//        System.out.println("INICIALIZANDO");
//    }
//
//    public void NoExistePad() {
//        System.out.println("NON HAI PAD");
//    }
//
//    public void ExistePad() {
//        System.out.println("HAI PAD");
//    }
//
//    public void createPad() {
//        System.out.println("*** CREATING PAD ***");
//    }
//
//    public void deletePad() {
//        System.out.println("*** DELETING PAD ***");
//    }
//
//    public void getText() {
//        System.out.println("*** READING FROM PAD ***");
//    }
//
//    public void setText() {
//        System.out.println("*** WRITTING PAD ***");
//    }
	
	@Override
	public void v_Revisions() {
		System.out.println("*** CHECKING REVISIONS ***");

	}

	@Override
	public void v_CreatedPad() {
		System.out.println("*** CREATING PAD ***");

	}

	@Override
	public void v_NoPad() {
		System.out.println("No pad");

	}

	@Override
	public void e_GetText() {
		System.out.println("Obtaining pad text");

	}

	@Override
	public void e_DeletePad() {
		System.out.println("*** DELETING PAD ***");

	}

	@Override
	public void e_CheckRevisions() {
		System.out.println("Going to check revisions");

	}

	@Override
	public void e_CreatePad() {
		System.out.println("*** CREATING PAD ***");

	}

	@Override
	public void e_Connect() {
		System.out.println("*** Connecting with server ***");

	}

	@Override
	public void e_ReturnToPad() {
		System.out.println("Exiting check revisions");

	}

	@Override
	public void e_SetText() {
		System.out.println("*** WRITTING ON PAD ***");

	}

	@Override
	public void e_GetSavedRevisionsCount() {
		System.out.println("Checking pad's revisions");

	}

	@Override
	public void e_GetChatHistory() {
		System.out.println("Checking pad chat history");

	}

	@Override
	public void e_PadUsers() {
		System.out.println("Checking pad's modifiers");

	}

	@Override
	public void e_GetRevisionChangeset() {
		String revisionNumber = getAttribute("revisionNumber").toString();
		System.out.println("Checking revision number: " + revisionNumber);

	}


	
}
