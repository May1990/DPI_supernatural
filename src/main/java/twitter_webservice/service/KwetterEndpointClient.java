package twitter_webservice.service;

import javax.ejb.Stateless;
import javax.websocket.Session;
import java.util.logging.Logger;


/**
 * Created by Anna-May on 27/05/2017.
 */
@Stateless
//@RequestScoped
public class KwetterEndpointClient{ //extends Endpoint{
    private Session session;
    private static final Logger LOG = Logger.getLogger(KwetterEndpoint.class.getName());

//
//

//    PartialViewContext pw;
//

////    private final PushServlet pushServlet = new PushServlet();
////
//    public void onOpen(final Session session, EndpointConfig config){
//        this.session = session;
////        this.eventUpdateHandler = eventUpdateHandler;
////        this.updateTweetsEvent = updateTweetsEvent;
//
//        this.session.addMessageHandler(new MessageHandler.Whole<String>() {
//            public void onMessage(String message){
//                LOG.info("!!!! retrieved: "+ session.getRequestURI().toString());
//                LOG.info("!!!! retrieved: "+ message);
////                try{
////                    tw.updateOnMessage();
//////                    eventUpdateHandler.handleEvent(updateTweetsEvent);
////                }catch (Exception ex){
////                    Logger.getLogger(KwetterEndpoint.class.getName()).log(Level.SEVERE, null, ex);
////                }
////                try{
////                    EventBusFactory.getDefault().eventBus().publish("/onMessageEvent", "There was another registration");
////                }catch (Exception ex){
////                    Logger.getLogger(KwetterEndpoint.class.getName()).log(Level.SEVERE, null, ex);
////                }
//            }
//        });
//    }

//    public void sendMessage(String message) throws IOException {
//        this.session.getAsyncRemote().sendText(message);
//    }

//    public void observeRegistrationActivity(@Observes RegistrationActivity someRegistrationActivity) {
//        EventBusFactory.getDefault().eventBus().publish("/onMessageEvent", "There was another registration");
//    }
}
