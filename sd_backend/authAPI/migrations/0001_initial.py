# Generated by Django 2.1.4 on 2018-12-20 09:45

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='User',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('phoneNumber', models.CharField(default=0, help_text='The User Phone Number', max_length=10)),
                ('password', models.CharField(help_text='The User Password', max_length=64)),
            ],
        ),
    ]
