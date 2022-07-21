package com.pandasby.pettest.data.api

/**
 * Temporary solution for request bodies. Use raw json string instead of pojo
 */
object DnDRequestBodies {

    const val fetchClassesBody = """{
    "page": 0,
    "search": {
        "exact": false,
        "value": ""
    },
    "order": [
        {
            "field": "name",
            "direction": "asc"
        }
    ],
    "filter": {
        "book": [
            "PHB",
            "TCE",
            "DMG",
            "XGE",
            "FTD",
            "SCAG",
            "GGR",
            "EGtW",
            "VRGR"
        ],
        "hitdice": []
    }
}"""

    const val fetchClassDetailsBody = """{
    "filter": {
        "book": [
            "PHB",
            "TCE",
            "DMG",
            "XGE",
            "FTD",
            "SCAG",
            "GGR",
            "EGtW",
            "VRGR"
        ],
        "hitdice": []
    }
}"""

    const val spellRequestBody = """{
    "page": 0,
    "limit": 1000,
    "order": [
        {
            "field": "level",
            "direction": "asc"
        },
        {
            "field": "name",
            "direction": "asc"
        }
    ],
    "filter": {
        "level": [],
        "components": [],
        "school": [],
        "class": [
            "1"
        ],
        "book": [
            "PHB",
            "TCE",
            "DMG",
            "XGE",
            "FTD",
            "SCAG",
            "GGR",
            "EGtW",
            "VRGR"
        ]
    }
}"""
}