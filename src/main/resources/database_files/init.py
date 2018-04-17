import os
from sys import argv as args
# import threading as thd


# def generate_progress_bars():
#     """
#         function used for creating the progress bars shown below <progress_bars>
#         customize the length of <progress_bar> with appending or removing '#'
#     """
#     progress_bar = "##########################"
#     progress_bars = []

#     for i in range(len(progress_bar)):
#         progress_bars.append(progress_bar[0:i] + progress_bar[i:].replace('#', '.'))
#     progress_bars.append(progress_bar)

#     return progress_bars


# done = False


# def show_progress():

#     progress_bars = generate_progress_bars()
#     os.system(r'printf "The task is in progress, please wait a few seconds\n" ')
#     while not done:
#         for progress_bar in progress_bars:
#             os.system(r'printf "\r{} Processing..." '.format(progress_bar))
#             os.system("sleep 0.1")
#     os.system(r'printf "\rDone!" '.format(progress_bar))


usage = """
usage : python3 init.py [--dbname <name of the database>]

example : python3 init.py --dbname InventoryManagementSystem
"""

if(len(args) < 3 or args[1] != '--dbname'):
    print(usage)
    quit()

dbname = args[2]

print("running script for initializing the database ..")
print("Beware it will drop the database '{}' if exists".format(dbname))
print("creating DB Schema {} ..".format(dbname))

val = 0

if(dbname == 'ims'):
    os.system("mysql -u root -p < init.sql ")
else:
    with open("init.sql", "r") as initsql:
        with open("init.sql.tmp", "w") as tmp:
            tmp.write(initsql.read().replace("ims", dbname))
        # thd_a = thd.Thread(target=show_progress)
        val = os.system("mysql -u root -p < init.sql.tmp")
        # done = True
        # thd_a.
        os.system("rm init.sql.tmp")


if(val != 0):
    print("DB Schema was not created ")
    quit()

print("DB Schema {} created ".format(dbname))
print("Init data ? [y/n]")
opt = input()

if(opt[0:1].lower() == 'n'):
    pass
else:
    print("dumping data into DB {} ..".format(dbname))
    os.system("touch initdata.sql.tmp && echo 'use {} ;' > initdata.sql.tmp".format(dbname))
    os.system("cat initdata.sql >> initdata.sql.tmp")
    # thd.Thread(target=show_progress).start()
    val = os.system("mysql -u root -p < initdata.sql.tmp")
    os.system("rm initdata.sql.tmp")
    # done = True
    if(val != 0):
        print("data was not dumped successfully")
        quit()
    else:
        print("data successfully dumped into DB {} ".format(dbname))


print("Excecution complete")
