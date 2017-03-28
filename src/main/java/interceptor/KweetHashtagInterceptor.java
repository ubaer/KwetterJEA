package main.java.interceptor;

import main.java.domain.Kweet;
import main.java.domain.Tag;
import main.java.service.TagService;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Created by Kevin on 28-3-2017.
 */
@Interceptor
@KweetHashtag
public class KweetHashtagInterceptor {
    @Inject
    TagService tagService;

    @AroundInvoke
    public Object aroundInvoke(InvocationContext ic) throws Exception {
        Object[] methodParameters = ic.getParameters();

       if(ic.getMethod().getName()== "addKweet") {

           if (methodParameters.length != 0) {
               Kweet originalKweet = (Kweet) methodParameters[0];
               String kweetMessage = originalKweet.getMessage();

               if (kweetMessage.contains("2015")) {
                   kweetMessage = kweetMessage.replace("2015", "#2015");
                   originalKweet.addTag(new Tag("#2015"));
               }
               if (kweetMessage.contains("2016")) {
                   kweetMessage = kweetMessage.replace("2016", "#2016");
                   originalKweet.addTag(new Tag("#2016"));
               }
               if (kweetMessage.contains("2017")) {
                   kweetMessage = kweetMessage.replace("2017", "#2017");
                   originalKweet.addTag(new Tag("#2017"));
               }

               originalKweet.setMessage(kweetMessage);

               methodParameters[0] = originalKweet;

               ic.setParameters(methodParameters);
           }
       }
        return ic.proceed();
    }
}
