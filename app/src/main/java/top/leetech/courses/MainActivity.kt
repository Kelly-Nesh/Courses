package top.leetech.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import top.leetech.courses.data.DataSource
import top.leetech.courses.model.Topic
import top.leetech.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursesTheme {
                Surface(modifier = Modifier.statusBarsPadding()) {
                    CourseApp()
                }
            }
        }
    }
}

@Composable
fun CourseApp(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(DataSource.topics + DataSource.topics) {
            GridItem(it)
        }
    }
}

@Composable
fun GridItem(topic: Topic, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .height(68.dp)
            .clip(RoundedCornerShape(8.dp)).background(Color.hsl(0.0f,0.0f,0.9f))
    ) {
        Image(
            painter = painterResource(topic.image),
            contentDescription = stringResource(topic.title),
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1.0F, true)
        )
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 4.dp)
        ) {
            Text(
                text = stringResource(topic.title),
                modifier = modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.bodyMedium
            )
            Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(R.drawable.ic_grain),
                    contentDescription = null,
                    modifier = modifier.padding(end = 8.dp)
                )

                Text(
                    text = topic.coursesCount.toString(),
                    modifier = modifier,
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoursesTheme {
        CourseApp()
    }
}