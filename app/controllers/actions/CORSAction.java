package controllers.actions;

import play.libs.F;
import play.mvc.Http;
import play.mvc.Result;

public class CORSAction extends play.mvc.Action.Simple {
    @Override
    public F.Promise<Result> call(Http.Context ctx) throws Throwable {
        Http.Response response = ctx.response();
        response.setHeader("Access-Control-Allow-Origin", "*");
        if ("OPTIONS" .equals(ctx.request().method())) {
            response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            response.setHeader("Access-Control-Allow-Headers", "Accept, Origin, Content-type, X-Json, X-Prototype-Version, X-Requested-With");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Max-Age", String.valueOf(60 * 60 * 24));

        }
        return delegate.call(ctx);
    }
}
