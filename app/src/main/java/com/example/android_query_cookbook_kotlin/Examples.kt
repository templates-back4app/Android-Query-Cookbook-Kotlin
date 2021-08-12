package com.example.android_query_cookbook_kotlin

import android.util.Log
import com.parse.ParseException
import com.parse.ParseGeoPoint
import com.parse.ParseObject
import com.parse.ParseQuery
import java.util.*

class Examples {
    companion object {
        private const val TAG = "Examples"
    }
}

class QueryRetrievers {

    companion object {
        private const val TAG = "QueryRetrievers"

        fun queryCancel() {
            val query = ParseQuery<ParseObject>("Profile")
            query.findInBackground()
            query.cancel()
        }

        fun queryCount() {
            val query = ParseQuery<ParseObject>("Profile")
            try {
                val queryCount = query.count()
                Log.d(Companion.TAG, "Count: $queryCount")
            } catch (parseException: ParseException) {
                parseException.printStackTrace()
            }
        }

        fun queryFind() {
            //This find function works synchronously.
            val query = ParseQuery<ParseObject>("Profile")
            try {
                val list = query.find()
                Log.d(Companion.TAG, "List: $list")
            } catch (e: ParseException) {
                e.printStackTrace()
            }
        }

        fun queryFindInBackground() {
            //This find function works asynchronously.
            val query = ParseQuery<ParseObject>("Profile")
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "ParseError: ", e)
                }
            }
        }

        fun queryGet() {
            //We can call a parse object with an object id with the get() function.
            val query = ParseQuery<ParseObject>("Profile")
            try {
                val `object` = query["C6ENdLnFdQ"]
                Log.d(Companion.TAG, "Object: $`object`")
            } catch (e: ParseException) {
                e.printStackTrace()
            }
        }

        fun queryGetFirst() {
            //We can call a parse object with an object id with the get() function.
            val query = ParseQuery<ParseObject>("Profile")
            try {
                val firstItem = query.first
                Log.d(Companion.TAG, "First Item: $firstItem")
            } catch (e: ParseException) {
                e.printStackTrace()
            }
        }

    }
}

class QueryConditioners {
    companion object {
        private const val TAG = "QueryConditioners"

        fun queryContainedIn() {
            val query = ParseQuery<ParseObject>("Profile")
            query.whereContainedIn("luckyNumbers", java.util.List.of(2, 7))
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryContains() {
            val query = ParseQuery<ParseObject>("Profile")
            query.whereContains("name", "da")
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryContainsAll() {
            val query = ParseQuery<ParseObject>("Profile")
            query.whereContainsAll("luckyNumbers", java.util.List.of(2, 7))
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryContainsAllStartingWith() {
            val query = ParseQuery<ParseObject>("Profile")
            query.whereContainsAllStartsWith("favoriteFoods", java.util.List.of("Shrimp", "Lobster"))
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryWhereDoesNotExist() {
            val query = ParseQuery<ParseObject>("Profile")
            query.whereDoesNotExist("premiumMembership")
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryDoesNotMatchKeyInQuery() {
            val query = ParseQuery<ParseObject>("Profile")
            val innerQuery = ParseQuery<ParseObject>("Profile")
            innerQuery.whereLessThan("friendCount", 50)
            query.whereDoesNotMatchKeyInQuery("friendCount", "friendCount", innerQuery)
            query.whereGreaterThan("friendCount", 10)
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryDoesNotMatchQuery() {
            val query = ParseQuery<ParseObject>("Profile")
            val innerQuery = ParseQuery<ParseObject>("Membership")
            innerQuery.whereGreaterThan("expirationDate", Date())
            query.whereExists("premiumMembership")
            query.whereDoesNotMatchQuery("premiumMembership", innerQuery)
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryEndsWith() {
            val query = ParseQuery<ParseObject>("Profile")
            query.whereEndsWith("name", "ie")
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryEqualTo() {
            val query = ParseQuery<ParseObject>("Profile")
            query.whereEqualTo("friendCount", 2)
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryExists() {
            val query = ParseQuery<ParseObject>("Profile")
            query.whereExists("premiumMembership")
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryFullText() {
            val query = ParseQuery<ParseObject>("Profile")
            query.whereFullText("name", "Spears")
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryGreaterThan() {
            val query = ParseQuery<ParseObject>("Profile")
            val calendar = Calendar.getInstance()
            calendar[1980, 8, 19, 59, 59] = 59
            val date = calendar.time
            query.whereGreaterThan("birthDay", date)
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryGreaterThanOrEqual() {
            val query = ParseQuery<ParseObject>("Profile")
            query.whereGreaterThanOrEqualTo("friendCount", 49)
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryLessThan() {
            val query = ParseQuery<ParseObject>("Profile")
            val calendar = Calendar.getInstance()
            calendar[1980, 8, 19, 59, 59] = 59
            val date = calendar.time
            query.whereLessThan("birthDay", date)
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryLessThanOrEqual() {
            val query = ParseQuery<ParseObject>("Profile")
            query.whereLessThanOrEqualTo("friendCount", 49)
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryMatches() {
            val query = ParseQuery<ParseObject>("Profile")
            query.whereMatches("name", "da", "i")
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryMatchesInQuery() {
            val query = ParseQuery<ParseObject>("Profile")
            val innerQuery = ParseQuery<ParseObject>("Profile")
            innerQuery.whereLessThan("friendCount", 50)
            query.whereMatchesKeyInQuery("friendCount", "friendCount", innerQuery)
            query.whereGreaterThan("friendCount", 10)
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryMatchesQuery() {
            val query = ParseQuery<ParseObject>("Profile")
            val innerQuery = ParseQuery<ParseObject>("Membership")
            innerQuery.whereGreaterThan("expirationDate", Date())
            query.whereExists("premiumMembership")
            query.whereMatchesQuery("premiumMembership", innerQuery)
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryNotEqualTo() {
            val query = ParseQuery<ParseObject>("Profile")
            query.whereNotEqualTo("friendCount", 2)
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryStartsWith() {
            val query = ParseQuery<ParseObject>("Profile")
            query.whereStartsWith("name", "Brit")
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }
    }
}

class QueryOrdering {

    companion object {
        private const val TAG = "QueryOrdering"

        fun queryAddAscending() {
            val query = ParseQuery<ParseObject>("Profile")
            query.addAscendingOrder("friendCount")
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryAddDescending() {
            val query = ParseQuery<ParseObject>("Profile")
            query.addDescendingOrder("friendCount")
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryAscending() {
            val query = ParseQuery<ParseObject>("Profile")
            query.orderByAscending("friendCount")
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryDescending() {
            val query = ParseQuery<ParseObject>("Profile")
            query.orderByDescending("friendCount")
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }
    }
}

class FieldSelecting {

    companion object {
        private const val TAG = "FieldSelecting"

        fun queryInclude() {
            val query = ParseQuery<ParseObject>("Profile")
            query.whereExists("premiumMembership")
            query.include("premiumMembership")
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                    Log.d(
                        Companion.TAG,
                        "Object Premium Membership: " + objects[0]["premiumMembership"]
                    )
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun querySelect() {
            val query = ParseQuery<ParseObject>("Profile")
            query.selectKeys(java.util.List.of("name"))
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                    Log.d(Companion.TAG, "Object name: " + objects[0]["name"])
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }
    }
}

class GeoPointQuerying {

    companion object {
        private const val TAG = "GeoPointQuerying"

        fun queryNear() {
            val query = ParseQuery<ParseObject>("Profile")
            query.whereNear("lastLoginLocation", ParseGeoPoint(37.38412167489413, -122.01268034622319))
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryPolygonContains() {
            val query = ParseQuery<ParseObject>("Profile")
            query.wherePolygonContains(
                "lastLoginLocation",
                ParseGeoPoint(37.38412167489413, -122.01268034622319)
            )
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryWithinGeoBox() {
            val query = ParseQuery<ParseObject>("Profile")
            query.whereWithinGeoBox(
                "lastLoginLocation",
                ParseGeoPoint(37.48412167489413, -122.11268034622319),
                ParseGeoPoint(37.28412167489413, -121.91268034622319)
            )
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryWithinKilometers() {
            val query = ParseQuery<ParseObject>("Profile")
            query.whereWithinKilometers(
                "lastLoginLocation",
                ParseGeoPoint(37.38412167489413, -122.01268034622319),
                100.0
            )
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryWithinMiles() {
            val query = ParseQuery<ParseObject>("Profile")
            query.whereWithinMiles(
                "lastLoginLocation",
                ParseGeoPoint(37.38412167489413, -122.01268034622319),
                100.0
            )
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryWithinPolygon() {
            val query = ParseQuery<ParseObject>("Profile")
            query.whereWithinPolygon(
                "lastLoginLocation", java.util.List.of(
                    ParseGeoPoint(37.48412167489413, -122.11268034622319),
                    ParseGeoPoint(37.48412167489413, -121.91268034622319),
                    ParseGeoPoint(37.28412167489413, -121.91268034622319),
                    ParseGeoPoint(37.28412167489413, -122.01268034622319)
                )
            )
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryWithinRadians() {
            val query = ParseQuery<ParseObject>("Profile")
            query.whereWithinRadians(
                "lastLoginLocation",
                ParseGeoPoint(37.38412167489413, -122.01268034622319),
                100.0
            )
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }
    }
}

class Pagination {

    companion object {
        private const val TAG = "Pagination"

        fun queryLimit() {
            val query = ParseQuery<ParseObject>("Profile")
            query.limit = 2
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun querySkip() {
            val query = ParseQuery<ParseObject>("Profile")
            query.skip = 2
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }
    }
}

class LocalDataStore {
    companion object {
        private const val TAG = "LocalDataStore"

        fun queryFromLocalDataStore() {
            val query = ParseQuery<ParseObject>("Profile")
            //If you want use LocalDataStore you should enable local data store in the App.java or App.kt file.
            query.fromLocalDatastore()
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryFromNetwork() {
            val query = ParseQuery<ParseObject>("Profile")
            query.fromNetwork()
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryFromPin() {
            val query = ParseQuery<ParseObject>("Profile")
            query.fromPin()
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

        fun queryFromPinWithName() {
            val query = ParseQuery<ParseObject>("Profile")
            query.fromPin("pinnedObjects")
            query.findInBackground { objects: List<ParseObject>, e: ParseException? ->
                if (e == null) {
                    Log.d(Companion.TAG, "Objects: $objects")
                } else {
                    Log.e(Companion.TAG, "Parse Error: ", e)
                }
            }
        }

    }
}