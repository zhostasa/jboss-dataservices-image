package org.infinispan.online.service.caching;

import org.arquillian.cube.kubernetes.annotations.Named;
import org.arquillian.cube.openshift.impl.requirement.RequiresOpenshift;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.infinispan.online.service.endpoint.HotRodTester;
import org.infinispan.online.service.endpoint.RESTTester;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.net.URL;

@RunWith(ArquillianConditionalRunner.class)
@RequiresOpenshift
public class CachingServiceTest {

   @Named("caching-service-app-hotrod")
   @ArquillianResource
   URL hotRodService;

   @Named("caching-service-app-http")
   @ArquillianResource
   URL restService;


   HotRodTester hotRodTester = new HotRodTester();
   RESTTester restTester = new RESTTester();

   @Test
   public void should_default_cache_be_accessible_via_hot_rod() throws IOException {
      hotRodTester.testBasicEndpointCapabilities(hotRodService);
   }

   @Test
   public void should_default_cache_be_accessible_via_REST() throws IOException {
      restTester.testBasicEndpointCapabilities(restService);
   }
}
