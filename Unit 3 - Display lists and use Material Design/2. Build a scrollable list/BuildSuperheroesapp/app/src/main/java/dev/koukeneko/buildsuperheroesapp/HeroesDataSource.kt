package dev.koukeneko.buildsuperheroesapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.koukeneko.buildsuperheroesapp.data.Hero

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun SuperDataCard(
    hero: Hero
) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = Modifier
//            .height(72.dp)
            .fillMaxWidth()
//            .padding(16.dp)
        ,
        shape = MaterialTheme.shapes.medium,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                Text(
                    text = stringResource(id = hero.nameRes),
                    style = MaterialTheme.typography.h3,)
                Text(
                    text = stringResource(id = hero.descriptionRes),
                    style = MaterialTheme.typography.body1,
                    )
            }
            Image(
                painter = painterResource(id = hero.imageRes),
                contentDescription = null,
                modifier = Modifier
//                    .padding(16.dp)
                    .size(72.dp)
            )
        }
    }
}