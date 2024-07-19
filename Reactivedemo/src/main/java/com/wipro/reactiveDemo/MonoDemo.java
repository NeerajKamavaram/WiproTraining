package com.wipro.reactiveDemo;

import java.io.IOException;

import java.time.Duration;

import reactor.core.publisher.Mono;

public class MonoDemo {

	public static void main(String[] args) throws IOException 
	{
//		Mono<Integer> mono=Mono.just(100).delayElement(Duration.ofSeconds(5));
//		mono.subscribe(n->System.out.println(n));
		
		Mono<User> monoFlux=Mono.just(new User(1, "Neeraj", 23)).delayElement(Duration.ofSeconds(2));
		monoFlux.subscribe(n->System.out.println(n.getUserId()+" "+n.getUserName()+" "+n.getAge()));
		
		System.out.println("next line executing");
		System.out.println("press any key to end:");
		System.in.read();
		System.out.println("ends");

	}

}
