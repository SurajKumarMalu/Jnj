package customer.xsuaa_authentication.handler;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sap.cds.services.cds.CdsReadEventContext;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.On;
import com.sap.cds.services.handler.annotations.ServiceName;
import com.sap.cds.services.request.UserInfo;

@Component
@ServiceName("UserService")
public class GetUser implements EventHandler {
    
    private final UserInfo userInfo ;

    public GetUser(UserInfo userInf) {
        this.userInfo = userInf;
    }
     @On(event = "getCurrentUser")
    public void onGetCurrentUser(CdsReadEventContext context) {
        Map<String, Object> currentUser = Map.of(
            "id", userInfo.getName(),       
            "email", userInfo.getEmail(),   
            "tenant", userInfo.getTenant(), 
            "roles", userInfo.getRoles()    
        );
        context.setResult(List.of(currentUser));
    }

}
