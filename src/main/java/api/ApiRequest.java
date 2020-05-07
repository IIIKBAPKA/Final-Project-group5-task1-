package api;

import io.qameta.allure.Step;

import java.io.IOException;

public class ApiRequest {
    RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
    Params params = new Params();
    @Step("Удаление пользователя с доски")
    public int deleteMember(String boardId) throws IOException {
        return retrofitBuilder.getTrelloApi().deleteMember(boardId, "user95411438", params.getKey(),params.getToken()).execute().code();
    }
    @Step("Разархивация списка")
    public int unArchiveList(String listId) throws IOException {
        return retrofitBuilder.getTrelloApi().archiveList(listId,params.getKey(),params.getToken(),"false").execute().code();
    }
    @Step("Удаление лейбла из карточки")
    public int deleteLabel(String cardId, String labelId) throws IOException{
        return retrofitBuilder.getTrelloApi().deleteLabel(cardId,labelId,params.getKey(),params.getToken()).execute().code();
    }
    public void deleteBoard(String boardId) throws IOException {
        retrofitBuilder.getTrelloApi().deleteBoard(boardId, params.getKey(), params.getToken()).execute();
    }
}