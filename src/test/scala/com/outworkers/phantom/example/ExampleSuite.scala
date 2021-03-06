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

//import com.outworkers.phantom.PhantomBaseSuite
import com.outworkers.phantom.dsl.{DatabaseProvider, context}
import com.outworkers.phantom.example.advanced.RecipesDatabase
import org.scalatest.{BeforeAndAfterAll, FlatSpec}

trait RecipesDbProvider extends DatabaseProvider[RecipesDatabase] {
  override def database: RecipesDatabase = RecipesDatabase
}

trait ExampleSuite extends FlatSpec /*with PhantomBaseSuite*/ with BeforeAndAfterAll with RecipesDbProvider {

  override def beforeAll(): Unit = {
    super.beforeAll()
    database.create()
  }
}
