package controller.connection;

import model.response.*;

public interface ResponseVisitor {
    void visit(SignInLoginResponse response);
    void visit(GameStartResponse response);
    void visit(GameStateStatusResponse response);
    void visit(NewPMResponse response);
    void visit(BuyResponse response);
    void visit(GameOverResponse response);
    void visit(RoomResponse response);
    void visit(DialogResponse response);
    void visit(EnterRoomResponse response);
    void visit(RoomUpdateResponse response);
    void visit(RoomChatUpdateResponse response);
    void visit(ClientUpdateResponse response);
    void visit(ScoreBoardResponse response);
    void visit(RoomCloseResponse response);
    void visit(ChatSearchResponse response);


}
