# Generated by Django 2.1.5 on 2019-02-16 18:57

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('authAPI', '0008_blood_bank_image'),
    ]

    operations = [
        migrations.AddField(
            model_name='blood_bank',
            name='latitude',
            field=models.CharField(default=0, help_text='The image of the campaign', max_length=2000),
        ),
        migrations.AddField(
            model_name='blood_bank',
            name='longitude',
            field=models.CharField(default=0, help_text='The image of the campaign', max_length=2000),
        ),
        migrations.AddField(
            model_name='campaign',
            name='latitude',
            field=models.CharField(default=0, help_text='The registered number of users in the campaign', max_length=200),
        ),
        migrations.AddField(
            model_name='campaign',
            name='longitude',
            field=models.CharField(default=0, help_text='The registered number of users in the campaign', max_length=200),
        ),
        migrations.AddField(
            model_name='user',
            name='latitude',
            field=models.CharField(default=0, help_text='The Reputation Point earnedby the user', max_length=100),
        ),
        migrations.AddField(
            model_name='user',
            name='longitude',
            field=models.CharField(default=0, help_text='The Reputation Point earnedby the user', max_length=100),
        ),
        migrations.AlterField(
            model_name='user',
            name='reputation',
            field=models.CharField(default=0, help_text='The Reputation Point earned by the user', max_length=100),
        ),
    ]
