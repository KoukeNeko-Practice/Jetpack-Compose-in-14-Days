package dev.koukeneko.buildagrid.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.koukeneko.buildagrid.R

//export default function component
@Composable
fun TopicCompose(topic: dev.koukeneko.buildagrid.model.Topic) {
    Card(
        modifier = Modifier
           .padding(top = 8.dp, start = 8.dp)
    ) {
        Row(
            modifier = Modifier

        ) {
            Image(
                painter = painterResource(id = topic.image),
                contentDescription = stringResource(id = topic.title),
                modifier = Modifier
                    .height(68.dp)
                    .width(68.dp)
            )
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, bottom = 8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween

            ) {
                Text(
                    text = stringResource(id = topic.title),
                    style = MaterialTheme.typography.labelLarge
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    //gap = 8.dp
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_confirmation_number_24),
                        contentDescription = "Number of lessons",
                        modifier = Modifier.size(16.dp),
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = topic.lessons.toString(),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}
