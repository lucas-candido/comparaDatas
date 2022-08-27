package com.pucpr.comparaDatas

import org.springframework.web.bind.annotation.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.concurrent.TimeUnit

@RestController
@RequestMapping("/api")
class DateController {

    @GetMapping("diff")
    @ResponseBody
    fun getDiff(
        @RequestParam(name="di", required=false, defaultValue = "2022-01-01") di : String,
        @RequestParam(name="df", required=false, defaultValue = "2022-12-31") df: String
    ) : String {

        val formatter: DateFormat = SimpleDateFormat("yyyy-MM-dd")
        val dataInicial = formatter.parse(di)
        val dataFinal = formatter.parse(df)
        val diff = dataFinal.time - dataInicial.time
        val diffInDays = TimeUnit.MILLISECONDS.toDays(diff)
        val diffInWeeks = diffInDays / 7
        val diffInMonths = diffInDays / 30


        return "A direfença de dias entre as datas é: $diffInDays <br>" +
                "A direfença de semanas entre as datas é: $diffInWeeks <br>" +
                "A direfença de meses entre as datas é: $diffInMonths"
    }

}