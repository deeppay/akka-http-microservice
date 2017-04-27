/*
 * Copyright 2013 - 2017 Outworkers Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.outworkers.phantom.example

import com.outworkers.phantom.dsl.{UUID, context}
import com.outworkers.phantom.example.basics.Recipe
import com.outworkers.phantom.dsl.DateTime
import org.joda.time.DateTime

import scala.concurrent.Future

class SimpleRecipesTest extends ExampleSuite {

  it should "insert a new record in the recipes table and retrieve it" in {
    val sample = new Recipe(new UUID(2626l, 26626l),
    "name",
    "title",
    "author",
    "desc",
      Set("a", "b"),
      Map.empty[String, String],
      DateTime.now()
    )


    val chain = for {
      store <- database.Recipes.store(sample).future()
      res <- database.Recipes.findRecipeById(sample.id)
    } yield res

    //chain.
  }

}
