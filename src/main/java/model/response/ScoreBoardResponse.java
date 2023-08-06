package model.response;

import controller.connection.ResponseVisitor;
import model.dto.score.ScoreBoardDTO;

public class ScoreBoardResponse extends Response{
    private ScoreBoardDTO scoreBoardDTO;

    public ScoreBoardResponse() {
    }

    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.visit(this);
    }

    public ScoreBoardDTO getScoreBoardDTO() {
        return scoreBoardDTO;
    }

    public void setScoreBoardDTO(ScoreBoardDTO scoreBoardDTO) {
        this.scoreBoardDTO = scoreBoardDTO;
    }
}
