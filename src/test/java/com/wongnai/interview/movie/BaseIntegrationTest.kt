package com.wongnai.interview.movie

import org.junit.Ignore
import org.springframework.test.context.TestPropertySource
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner::class)
@TestPropertySource(locations = ["classpath:application-test.properties"])
@Ignore("This is not meant to run on its own")
open class BaseIntegrationTest
