package com.luisbarbosa.convert.ConvertUnits;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ConvertUnitsConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(ConvertUnitsRepository convertUnitsRepository){
        return args -> {
            ConvertUnits hectare = new ConvertUnits(
                "hectare",
                    "ha",
                    "m²",
                    10000
            );
            ConvertUnits minute = new ConvertUnits(
                    "minute",
                    "min",
                    "s",
                    60
            );
            ConvertUnits hour = new ConvertUnits(
                    "hour",
                    "h",
                    "s",
                    3600
            );
            ConvertUnits day = new ConvertUnits(
                    "day",
                    "d",
                    "s",
                    86400
            );
            ConvertUnits degree = new ConvertUnits(
                    "degree",
                    "°",
                    "rad",
                    0.017453293f
            );
            ConvertUnits arcminute = new ConvertUnits(
                    "arcminute",
                    "'",
                    "rad",
                    0.017453293f
            );
            ConvertUnits arcsecond = new ConvertUnits(
                    "arcsecond",
                    "\"",
                    "rad",
                    0.000004848f
            );
            ConvertUnits litre = new ConvertUnits(
                    "litre",
                    "L",
                    "m³",
                    0.001f
            );
            ConvertUnits tonne = new ConvertUnits(
                    "tonne",
                    "t",
                    "kg",
                    1000
            );

            convertUnitsRepository.saveAll(
                    List.of(hectare,
                            minute,
                            hour,
                            day,
                            degree,
                            arcminute,
                            arcsecond,
                            litre,
                            tonne
                    )
            );
        };
    }
}
