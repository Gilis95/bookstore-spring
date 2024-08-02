package org.kiki;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpsConfiguration {
//
//    @Bean
//    public WebServerFactoryCustomizer<NettyServletWebServerFactory> servletContainerCustomizer() {
//        return new WebServerFactoryCustomizer<TomcatServletWebServerFactory>() {
//            @Override
//            public void customize(TomcatServletWebServerFactory factory) {
//                factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
//                    @Override
//                    public void customize(Connector connector) {
//                        AbstractHttp11Protocol<?> httpHandler = ((AbstractHttp11Protocol<?>) connector.getProtocolHandler());
//                        httpHandler.setUseServerCipherSuitesOrder(true);
//                        httpHandler.setSSLProtocol("TLSv1.2");
//                        httpHandler.setSSLHonorCipherOrder(true);
//                        httpHandler.setCiphers("TLS_EMPTY_RENEGOTIATION_INFO_SCSV,TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384,TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384,TLS_RSA_WITH_AES_256_GCM_SHA384");
//                    }
//                });
//            }
//        };
//    }

}