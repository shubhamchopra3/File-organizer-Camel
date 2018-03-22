package com.filetransfer;

import org.apache.camel.Predicate;
import org.apache.camel.builder.PredicateBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
	Predicate predicate = PredicateBuilder.and(simple("${file:name.ext} == 'pdf'"));
		from("file:D://cameltest?noop=true").choice()
        .when(predicate).to("file:D://cameltestout");
		
	}

	
	
}
