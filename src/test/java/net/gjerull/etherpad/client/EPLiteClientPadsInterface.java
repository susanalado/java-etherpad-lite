package net.gjerull.etherpad.client;

import org.graphwalker.java.annotation.Edge;
import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;

@Model(file = "net/qjerull/etherpad/client/EPLiteClientIntegrationPadRevisionTest.graphml")
public interface EPLiteClientPadsInterface {

	@Vertex()
	void v_CreatedPad();

	@Edge()
	void e_GetText();

	@Edge()
	void e_DeletePad();

	@Edge()
	void e_CheckRevisions();

	@Edge()
	void e_CreatePad();

	@Edge()
	void e_GetSavedRevisionsCount();

	@Edge()
	void e_Connect();

	@Edge()
	void e_GetChatHistory();

	@Edge()
	void e_SetText();

	@Edge()
	void e_PadUsers();

	@Vertex()
	void v_Revisions();

	@Vertex()
	void v_NoPad();

	@Edge()
	void e_GetRevisionChangeset();

	@Edge()
void e_ReturnToPad();
	
}
