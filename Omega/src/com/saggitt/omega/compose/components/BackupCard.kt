package com.saggitt.omega.compose.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.android.launcher3.R
import com.saggitt.omega.backup.BackupFile

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BackupCard(
    modifier: Modifier = Modifier,
    backup: BackupFile,
    cornerRadius: Dp = 16.dp,
    onShare: () -> Unit = {},
    onDelete: () -> Unit = {},
    onClick: () -> Unit = {}
) {
    var extended by remember { mutableStateOf(false) }
    var previewLoaded by remember { mutableStateOf(false) }
    val metaLoader by remember { mutableStateOf(BackupFile.MetaLoader(backup)) }
    metaLoader.callback = object : BackupFile.MetaLoader.Callback {
        override fun onMetaLoaded() {
            previewLoaded = true
        }
    }

    SideEffect { metaLoader.loadMeta(true) }

    Card(
        modifier = Modifier
            .heightIn(min = 64.dp)
            .clip(RoundedCornerShape(cornerRadius))
            .combinedClickable(onClick = onClick, onLongClick = { extended = !extended }),
        shape = RoundedCornerShape(cornerRadius),
    ) {
        AnimatedVisibility(previewLoaded) {
            metaLoader.meta?.preview?.second?.let {
                Image(
                    modifier = Modifier
                        .clip(RoundedCornerShape(cornerRadius))
                        .aspectRatio(1f)
                        .fillMaxWidth(),
                    bitmap = it.asImageBitmap(),
                    contentScale = ContentScale.FillWidth,
                    contentDescription = metaLoader.meta?.name
                        ?: stringResource(id = R.string.backup_invalid)
                )
            }
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = metaLoader.meta?.name ?: stringResource(id = R.string.backup_invalid),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 2
                )
                Text(
                    text = metaLoader.meta?.localizedTimestamp
                        ?: stringResource(id = R.string.backup_invalid),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        }
        AnimatedVisibility(visible = extended) {
            Row(
                modifier = Modifier.padding(8.dp)
            ) {
                ElevatedButton(onClick = onShare) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_share),
                        contentDescription = stringResource(id = R.string.backup_share)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                ElevatedButton(onClick = onDelete) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_delete),
                        contentDescription = stringResource(id = R.string.delete)
                    )
                }
            }
        }
    }
}
