package com.learn.attack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.learn.utils.Constants;

@TestInstance(Lifecycle.PER_CLASS)
public class PasswordAttackTest {

	@BeforeAll
	public void setUp() {
		Constants.loadProperties("/application-test.properties");
	}

}
