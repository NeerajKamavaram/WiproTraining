package com.wipro.reactiveDemo;

import java.io.IOException;
import java.time.Duration;

import reactor.core.publisher.Flux;

public class FluxDemo {

	public static void main(String[] args) throws IOException
	{
//		Flux<Integer> flux=Flux.range(1, 10).delayElements(Duration.ofSeconds(2));
//		
//		flux.subscribe(n->System.out.println(n));
		
		Flux<User> userFlux=Flux.just(new User(1, "Neeraj", 23),
				new User(1, "Nikhitha", 24),
				new User(1, "mahesh", 48)).log();
		
		userFlux.subscribe(n->System.out.println(n.getUserId()+" "+n.getUserName()+" "+n.getAge()));
		
				
								
				
				
				
				
		
		System.out.println("next line executing");
		
		System.out.println("press any key to end:");
		
		System.in.read();
		
		System.out.println("ends");

	}

}
