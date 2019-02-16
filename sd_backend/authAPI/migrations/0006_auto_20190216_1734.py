# Generated by Django 2.1.5 on 2019-02-16 17:34

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('authAPI', '0005_auto_20190216_1442'),
    ]

    operations = [
        migrations.AddField(
            model_name='campaign',
            name='description',
            field=models.CharField(default=0, help_text='The Description of the campaign', max_length=2000),
        ),
        migrations.AddField(
            model_name='campaign',
            name='registered_users',
            field=models.CharField(default=0, help_text='The registered number of users in the campaign', max_length=200),
        ),
        migrations.AddField(
            model_name='user',
            name='reputation',
            field=models.CharField(default=0, help_text='The Reputation Point earnedby the user', max_length=100),
        ),
        migrations.AddField(
            model_name='user',
            name='verified',
            field=models.CharField(default=0, help_text='The verification status of the donor', max_length=5),
        ),
    ]
